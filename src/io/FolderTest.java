package io;

import java.io.File;

public class FolderTest {

	public static void main(String[] args) {
		File path = new File("C:\\java_study\\address");
		if(path.isDirectory()) {
			File[] files = path.listFiles();
			for(File file:files) {
				if(!file.isDirectory() &&file.getName().indexOf("build_")==0) {
					System.out.println(file.getName()+"입력시작");
					long sTime = System.currentTimeMillis();
					Execute.insertlogic(file.getName());
					long eTime = System.currentTimeMillis();
					System.out.println(file.getName()+"한개완료, 실행시간 : "+(eTime-sTime));
				}
			}
		}
	}
}
