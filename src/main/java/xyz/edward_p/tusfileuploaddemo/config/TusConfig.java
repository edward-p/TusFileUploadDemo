package xyz.edward_p.tusfileuploaddemo.config;

import me.desair.tus.server.TusFileUploadService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author edward <br/>
 * Date: 3/20/21 3:10 PM <br/>
 * Description:
 */
@Configuration
public class TusConfig {
    @Bean
    public TusFileUploadService fileUploadService() {
        return new TusFileUploadService()
                .withUploadURI("/files") // 与 controller 一致
                .withStoragePath("/tmp/tus-data") // 文件上传保存路径
                .withDownloadFeature() // 提供下载
                .withMaxUploadSize(2L * 1024 * 1024 * 1024); // 最大上传文件大小
    }
}
