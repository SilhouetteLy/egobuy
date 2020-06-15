package com.silhouette.egobuy.controller.picture;

import com.silhouette.egobuy.utils.FastDFSClient;
import com.silhouette.egobuy.utils.JsonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liuyi
 * @version 1.0
 * @create -- 10:50
 * @description: 处理图片的上传和下载
 */
@Controller
@RequestMapping("/pic")
public class PictureController {
    private static final Logger LOGGER = LoggerFactory.getLogger(PictureController.class);

    @Value("${IMAGE_SERVER_URL}")
    private String IMAGE_SERVER_URL;

    @RequestMapping(value="/uploadPic",produces="text/plain;charset=utf-8")
    @ResponseBody
    public  String uploadPic(MultipartFile uploadFile) {
        Map<String,Object> result = new HashMap<>();
        // 使用工具类上传图片
        try {
            // 创建FastDFSClient对象
            FastDFSClient fastDFSClient = new FastDFSClient("classpath:conf/client.conf");
            // 获取文件的扩展名
            String originalFilename = uploadFile.getOriginalFilename();
            String extName = originalFilename.substring(originalFilename.lastIndexOf(".") + 1);
            // 上传图片
            String url = fastDFSClient.uploadFile(uploadFile.getBytes(), extName);
            //补全url
            url = IMAGE_SERVER_URL + url;
            // 响应结果
            result.put("error", 0);
            result.put("url",url);
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.info("图片上传失败:" + e.getMessage());
            result.put("error", 1);
            result.put("message","图片上传失败，请检查您的网络");
        }
        return JsonUtils.objectToJson(result);
    }


}
