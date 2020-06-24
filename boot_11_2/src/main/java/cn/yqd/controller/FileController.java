package cn.yqd.controller;

import cn.yqd.util.FileDFSUtil;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

@RestController
public class FileController {

    @Resource
    private FileDFSUtil fileDFSUtil;

    @ApiOperation(value="上传文件", notes="测试FastDFS文件上传")
    @RequestMapping(value = "/uploadFile",headers="content-type=multipart/form-data",method = RequestMethod.POST)
    public ResponseEntity<String> uploadFile (@RequestParam("file") MultipartFile file) {
        String result;
        try {
            String path = fileDFSUtil.upload(file);
            if (!StringUtils.isEmpty(path)) {
                result = path;
            } else {
                result = "上传失败";
            }
        } catch (Exception e) {
            e.printStackTrace();
            result = "服务异常";
        }
        return ResponseEntity.ok(result);
    }

    public ResponseEntity<String> deleteByPath (@PathVariable String filePathName) {
        fileDFSUtil.deleteFile(filePathName);
        return ResponseEntity.ok("SUCCESS");
    }
}
