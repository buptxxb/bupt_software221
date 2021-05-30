package Search;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class SearchBar {

	static int m=1;
    static void search(File a,String x) throws IOException{//在文件a中的每行中查找x
        Scanner scan = new Scanner(a,"gbk");
        int k = 0;
        while(true){    
            if(scan.hasNext()==false) break;
            String s = scan.nextLine();
            k++;
            if(s.contains(x)){
                String ss =m +".文件:"+ a.getPath() + " 第" + k + "行 \n  内容：" + s;
                System.out.println(ss);
                m++;
            }
        } 
        Scanner scan1 = new Scanner(a,"utf-8");
        int k1 = 0;
        while(true){    
            if(scan1.hasNext()==false) break;
            String s1 = scan1.nextLine();            
            k1++;
            if(s1.contains(x)){
                String ss1 =m +".文件:"+ a.getPath() + " 第" + k1 + "行 \n  内容：" + s1;
                System.out.println(ss1);
                m++;
            }
        } 
    }
    static void f(File a,String s)throws IOException{//在a下所有文件中查找含有s的行
        
        File[] ff = a.listFiles();
        if(ff==null) return;
        for(File it : ff){
            if(it.isFile()){//若a是文件，直接查找
                search(it,s);
            }
            if(it.isDirectory()){//若a是目录，则对其目录下的目录或文件继续查找
                f(it,s);
            }
        }        
    }
//
    public static void main(String[] args)throws IOException {
    	 Scanner sc = new Scanner(System.in); 
         System.out.println("请输入你的搜索："); 
         String s = sc.nextLine(); 
 //
		f(new File("F:\\search"),s);

    }

}