package cn.yqd.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.TreeMap;

@Controller
public class IndexController {

    /**
     * 单文件上传
     * @param file
     * @return
     */
    @RequestMapping("/uploadOne")
    @ResponseBody
    public TreeMap<String, Object> uploadOne(@RequestParam("file")MultipartFile file) {
        TreeMap<String, Object> resultMap = new TreeMap<>();

        if (file.isEmpty()) {
            resultMap.put("fail", "上传失败，请选择文件");
            return resultMap;
        }

        String filename = file.getOriginalFilename();
        String filePath = "D:\\Files\\Documents\\Others\\";
        File dest = new File(filePath + filename);
        try {
            file.transferTo(dest);
            resultMap.put("success","上传成功");
            return resultMap;
        } catch (IOException e) {
            resultMap.put("fail", "上传失败，IOException");
            return resultMap;
        }
    }

    @RequestMapping("/uploadMany")
    @ResponseBody
    public TreeMap<String, Object> uploadOne(HttpServletRequest request) {
        List<MultipartFile> files = ((MultipartHttpServletRequest) request).getFiles("file");
        TreeMap<String, Object> resultMap = new TreeMap<>();

        String filePath = "D:\\Files\\Documents\\Others\\";
        for (int i = 0; i < files.size(); i++) {
            MultipartFile file = files.get(i);
            if (file.isEmpty()) {
                resultMap.put("fail" + (i+1),"第" + (i+1) + "个文件为空");
            }
            String filename = file.getOriginalFilename();
            File dest = new File(filePath + filename);
            try {
                file.transferTo(dest);
                resultMap.put("success" + (i+1),"第"+(i+1)+"个文件上传成功");
            } catch (IOException e) {
                resultMap.put("fail"+ (i+1),"第"+(i+1)+"个文件上传失败");
            }
        }
        return resultMap;
    }

    @RequestMapping({"/index","/"})
    public String index() {
        return "uploadpage";
    }

}
