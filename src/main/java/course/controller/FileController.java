package course.controller;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import course.bean.User;

@Controller
public class FileController {
	@RequestMapping("/upFile")
	public String upFile()
	{
		return "upFile";
	}
	public String fileUpLoad(HttpServletRequest request,@ModelAttribute("user") User user, String name,@RequestParam("file") MultipartFile file) throws Exception{
		if(!file.isEmpty()){ 
	            //可以对user做一些操作如存入数据库
                    //以下的代码是将文件file重新命名并存入Tomcat的webapps目录下项目的下级目录fileDir
    		    String fileRealName = file.getOriginalFilename();                   //文件名;
    		    int pointIndex =  fileRealName.indexOf(".");                        //点的位置	    
    		    String fileSuffix = fileRealName.substring(pointIndex);             //后缀
				UUID FileId = UUID.randomUUID();                        //前缀
				String savedFileName = FileId.toString().replace("-","").concat(fileSuffix);       //文件存取名
				String savedDir = request.getSession().getServletContext().getRealPath("fileDir"); //获取服务器指定文件存取路径	
				File savedFile = new File(savedDir,savedFileName );
				boolean isCreateSuccess = savedFile.createNewFile();
				if(isCreateSuccess){					
					file.transferTo(savedFile);  //转存文件
				}
				return "success";	
    	 }
    	 return "error";
}
	
	}
 