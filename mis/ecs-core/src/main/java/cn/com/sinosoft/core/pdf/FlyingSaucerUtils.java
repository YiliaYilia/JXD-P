package cn.com.sinosoft.core.pdf;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import org.apache.commons.lang3.time.DurationFormatUtils;
import org.xhtmlrenderer.pdf.ITextFontResolver;
import org.xhtmlrenderer.pdf.ITextRenderer;
import com.lowagie.text.DocumentException;
import com.lowagie.text.pdf.BaseFont;

public class FlyingSaucerUtils {
	public static void initFlyingSaucerFonts(ITextRenderer renderer, String fontDir){
		try {
			ITextFontResolver fontResolver = renderer.getFontResolver();
			File f = new File(fontDir);
			
			if (f.isDirectory()) {
				
			    File[] files = f.listFiles(new FilenameFilter() {
			        public boolean accept(File dir, String name) {
			        	System.out.println(name);
			            String lower = name.toLowerCase();
			            return lower.endsWith(".otf") || lower.endsWith(".ttf") || lower.endsWith(".ttc");
			        }
			    });
			    StopWatch stopWatch = new StopWatch();
				stopWatch.start();
			    for (int i = 0; i < files.length; i++) {
			    	fontResolver.addFont(files[i].getAbsolutePath(),BaseFont.IDENTITY_H,BaseFont.NOT_EMBEDDED);
			    }
			    stopWatch.stop();
			    String processTime = DurationFormatUtils.formatDurationHMS(stopWatch.getTime());
			    System.out.println("load font File: " + processTime);
			}
		} catch (DocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}