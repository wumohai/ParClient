package com.mainClient;

import java.awt.Desktop;
import java.io.*;
import java.util.Scanner;

import registerimplement.RegisterImp;
import registerinterface.RegisterInter;
import loginimp.LoginImplement;
import logininter.LoginInterface;

import com.demo.File.ReadFile;
import com.demo.analysis.AnalysisCommandImp;
import com.demo.analysis.AnalysisCommandInter;
import com.demo.analysis.FileType;
import com.demo.content.ContentFacadeImp;
import com.demo.content.ContentFacadeInter;
import com.demo.content.RetContentBean;
import com.demo.menu.*;

public class MainClient {

	private MenuImp menuImp;
	private MenuInter menuInter;
	private AnalysisCommandImp analysisCommandImp;
	private AnalysisCommandInter analysisCommandInter;
	private ContentFacadeImp contentFacadeImp;
	private ContentFacadeInter contentFacadeInter;
	private ReadFile readFile;

	public MainClient() {
		menuImp = new MenuImp();
		menuInter = menuImp.getMenuImpPort();
		analysisCommandImp = new AnalysisCommandImp();
		analysisCommandInter = analysisCommandImp.getAnalysisCommandImpPort();
		contentFacadeImp = new ContentFacadeImp();
		contentFacadeInter = contentFacadeImp.getContentFacadeImpPort();
		readFile = new ReadFile();

	}

	/*
	 * 显示主菜单，调用getMenu方法，从服务器上获取菜单目录
	 */
	private void Menu() {
		System.out.println(menuInter.getMenu());
	}

	/*
	 * 解析客户端输入的命令
	 */
	@SuppressWarnings("unused")
	private String Analysis(String cmdString) {
		return analysisCommandInter.fixCommand(cmdString);

	}

	/*
	 * 获取文件路径
	 */
	@SuppressWarnings("unused")
	private String getFilePath(FileType fileType) {
		return fileType.getFileType() + "/" + fileType.getFileName();
	}
	private void openLocalFile(String path) {
		try {
			Desktop.getDesktop().open(new File(path));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@SuppressWarnings("resource")
	private static boolean login() {
		String usernameString;
		String passwdString;
		
		Scanner in=new Scanner(System.in);
		System.out.println("--------------------用户登录系统----------------------");
		System.out.println("请输入用户名：");
		usernameString = in.nextLine();
		System.out.println("请输入密码 ：");
		passwdString = in.nextLine();
		System.out.println("--------------------------------------------------------");
		
		LoginImplement loginImplement = new LoginImplement();
		LoginInterface loginInterface = loginImplement.getLoginImplementPort();
		
		return loginInterface.login(usernameString, passwdString);
	}
	@SuppressWarnings({ "resource" })
	private static int chose() {
		int ret = 0;
		Scanner in=new Scanner(System.in);
		while(true)
		{
		System.out.println("--------------------------------------------------------");
		System.out.println("1、登录");
		System.out.println("2、注册新用户");
		ret = in.nextInt();
		System.out.println("--------------------------------------------------------");
		if(ret != 1 && ret != 2)
		{
			System.out.println("选择错误，请重新选择");
		}
		else {
			return ret;
		}	
		}
		
	}
	@SuppressWarnings("resource")
	private static void register() {
		RegisterImp registerImp = new RegisterImp();
		RegisterInter registerInter = registerImp.getRegisterImpPort();
		boolean reg;
		
		Scanner in = new Scanner(System.in);
		String userName, passWord1, passWord2;
		
		
		while(true){
			System.out.println("---------------------用户注册系统------------------------");
			System.out.println("请输入新用户名：");
			userName = in.nextLine();
			System.out.println("请输入新密码：");
			passWord1 = in.nextLine();
			System.out.println("请再次输入新密码：");
			passWord2 = in.nextLine();
			if (passWord1.equals(passWord2) == true) {
				
				//写服务器
				reg = registerInter.register(userName, passWord1);
				
				if(reg == true)
				{	System.out.println("新用户 " + userName + " 注册成功");
					System.out.println("--------------------------------------------------------");
					break;
				}
				else {
					System.out.println("已存在该新用户。");
					System.out.println("--------------------------------------------------------");
				}
			}
			else {
				System.out.println("两次密码输入不一致，请重新输入。");
			}
		}
	
		
		
		
		
	}
	
	public static void main(String[] args) {

		MainClient mainClient = new MainClient();
		BufferedReader strin = new BufferedReader(new InputStreamReader(
				System.in));
		String cmdString = "";
		String fixCommandString = null;
		RetContentBean retContentBean = null;
		FileType fileType = null;
		
		if(chose() == 2)
		{
			//注册新用户
			register();
			
		}
		
		//登录
		while (login() == false) {
			System.out.println("用户名或者密码错误。请重新输入。");
		}
		//end 	while (login() == false) 登录成功
		
		while (true) {
			
		
			
			System.out.println("--------------------------------------------------------");
			mainClient.Menu();
			System.out.println("--------------------------------------------------------");
			System.out.println("请输入您的选择或者命令：");
			try {

				do {
					cmdString = strin.readLine().trim();// 读取命令

					if (cmdString.equalsIgnoreCase("0")) {
						System.out.println("退出系统");
						return;
					}

					fixCommandString = mainClient.analysisCommandInter
							.fixCommand(cmdString);// 转化成系统命令
					if (fixCommandString == null) {
						
						
						
						System.out.println("\"" + cmdString + "\""
								+ " 命令不存在，请重新输入：");
						System.out.println("----------------------------");
						// continue;
					}

				} while (fixCommandString == null);

				// 去掉开头结尾空格
				String changedCmd = fixCommandString.trim();

				// 获取命令对应的文件信息
				fileType = mainClient.analysisCommandInter
						.getFileType(changedCmd);
				if (fileType == null) {
					System.out.println("get FileType error");
					continue;
				}

				/*
				 * 获取内容
				 */
				retContentBean = mainClient.contentFacadeInter
						.getContent(changedCmd);
				if (retContentBean == null) {
					System.out.println("get Content error");
					continue;
				}
				String fileTypesString = fileType.getFileType();

				if (fileTypesString.equalsIgnoreCase("component")) {
					/*
					 * 表示构件，输出到控制台界面
					 */
					if(retContentBean.getRetString() == null)
					{
						System.out.println("get component error");
						continue;
					}
					System.out.println(retContentBean.getRetString());
				}// end if (fileTypesString.equalsIgnoreCase("component"))
				else if (fileTypesString.equalsIgnoreCase("image")) {

					/*
					 * 获取文件路径
					 */
					// String filePathString = mainClient.analysisCommandInter
					// .getFilePath(fileType);

					/*
					 * 写入文件
					 */
					// mainClient.readFile.WriteFileByBytes(filePathString,
					// retContentBean.getRetbyte());
					if (retContentBean.getRetbyte() == null) {
						System.out.println("get image error");
						continue;
					}
					mainClient.readFile.WriteFileByBytes(fileType,
							retContentBean.getRetbyte());
					String path = mainClient.getFilePath(fileType);
					mainClient.openLocalFile(path);

				}// end if (fileTypesString.equalsIgnoreCase("image"))
				else if (fileTypesString.equalsIgnoreCase("help")) {
					
					/*
					 * 输出到控制台
					 */
					if (retContentBean.getRetString() == null) {
						System.out.println("get help error");
						continue;
					}
					System.out.println(retContentBean.getRetString());
					
				}// end if (fileTypesString.equalsIgnoreCase("help"))
				else if (fileTypesString.equalsIgnoreCase("document")) {

					/*
					 * 输出到文件
					 */
					if(retContentBean.getRetbyte() == null)
					{
						System.out.println("get document error");
						continue;
					}
					
					mainClient.readFile.WriteFileByBytes(fileType,
							retContentBean.getRetbyte());
					String path = mainClient.getFilePath(fileType);
					mainClient.openLocalFile(path);
				}
				else if (fileTypesString.equalsIgnoreCase("apla")) {
					
					if (retContentBean.getRetString() == null) {
						System.out.println("get apla content error");
						continue;
					}
					System.out.println(retContentBean.getRetString());
					
				}
				else {
					System.out.println("未知类型");
				}
				System.out.println("按回车键返回");
				strin.readLine();
				// System.out.println("run succ");

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
