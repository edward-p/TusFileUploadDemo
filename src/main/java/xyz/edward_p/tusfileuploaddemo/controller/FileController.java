package xyz.edward_p.tusfileuploaddemo.controller;

import me.desair.tus.server.TusFileUploadService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static me.desair.tus.server.HttpHeader.*;

/**
 * @author edward <br/>
 * Date: 3/20/21 3:13 PM <br/>
 * Description:
 */
@RestController
@RequestMapping("/files")
// 设置跨域并暴露所需头
@CrossOrigin(exposedHeaders = {
        METHOD_OVERRIDE,
        CACHE_CONTROL,
        CONTENT_TYPE,
        CONTENT_LENGTH,
        CONTENT_DISPOSITION,
        LOCATION,
        TRANSFER_ENCODING,
        UPLOAD_OFFSET,
        UPLOAD_METADATA,
        UPLOAD_CHECKSUM,
        UPLOAD_LENGTH,
        UPLOAD_EXPIRES,
        UPLOAD_DEFER_LENGTH,
        UPLOAD_CONCAT,
        TUS_VERSION,
        TUS_RESUMABLE,
        TUS_EXTENSION,
        TUS_MAX_SIZE,
        TUS_CHECKSUM_ALGORITHM,
        X_FORWARDED_FOR
})
public class FileController {
    @Resource
    private TusFileUploadService fileUploadService;


    @RequestMapping(value = {"", "/**"}, method = {RequestMethod.POST,
            RequestMethod.PATCH, RequestMethod.HEAD, RequestMethod.DELETE, RequestMethod.GET})
    public void files(HttpServletRequest request, HttpServletResponse response) throws IOException {

        fileUploadService.process(request, response);
    }

}
