package com.mainClient;

import java.io.*;

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

	public static void main(String[] args) {

		MainClient mainClient = new MainClient();
		BufferedReader strin = new BufferedReader(new InputStreamReader(
				System.in));
		String cmdString = "";
		String fixCommandString = null;
		RetContentBean retContentBean = null;
		FileType fileType = null;

		while (true) {
			System.out.println("----------------------------");
			mainClient.Menu();
			System.out.println("----------------------------");
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
