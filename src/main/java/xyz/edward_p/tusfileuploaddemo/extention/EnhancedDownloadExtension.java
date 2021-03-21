package xyz.edward_p.tusfileuploaddemo.extention;

import me.desair.tus.server.RequestHandler;
import me.desair.tus.server.download.DownloadExtension;
import me.desair.tus.server.download.DownloadGetRequestHandler;
import me.desair.tus.server.download.DownloadOptionsRequestHandler;

import java.util.List;

/**
 * @author edward <br/>
 * Date: 3/22/21 12:08 AM <br/>
 * Description: 支持非 ascii 文件名下载
 */
public class EnhancedDownloadExtension extends DownloadExtension {

    @Override
    protected void initRequestHandlers(List<RequestHandler> requestHandlers) {
        requestHandlers.add(new EnhancedDownloadGetRequestHandler());
        requestHandlers.add(new DownloadOptionsRequestHandler());
    }
}
