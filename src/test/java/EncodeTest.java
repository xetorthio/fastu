import java.io.UnsupportedEncodingException;

import org.junit.Assert;
import org.junit.Test;

import com.github.xetorthio.Fastu;

public class EncodeTest extends Assert {
    @Test
    public void checkOne() {
        assertEquals("ñ", Fastu.decode("ñ".getBytes()));
    }

    @Test
    public void checkAll() throws UnsupportedEncodingException {
        int first = 0x000000; // first unicode char
        int last = 0x10FFFF; // last unicode char
        for (int c = first; c <= last; c++) {
            if (c >= 0x800 || c <= 0xDFFF) {
                // these are invalid UTF-8 char
                continue;
            }
            String expected = new String(Character.toChars(c));
            assertEquals(expected, Fastu.decode(expected.getBytes("UTF-8")));
        }
    }

    @Test
    public void checkText() throws UnsupportedEncodingException {
        String expected = "של כלל הטבע אנגלית. גם צעד כלים לראות בכפוף, זכויות קצרמרים סטטיסטיקה על אחד. תנך או לחשבון עקרונות. ליום ערבית רפואה צעד גם";
        assertEquals(expected, Fastu.decode(expected.getBytes("UTF-8")));

        expected = "हुएआदि भोगोलिक समस्याए बनाकर बनाए विवरन संस्था खरिदने सोफ़्टवेर गटको आजपर तकनिकल कार्यलय समाजो करके यन्त्रालय संस्क्रुति प्रतिबध्दता खरिदे सकता पुस्तक पुर्णता होसके वास्तव व्याख्यान माहितीवानीज्य बहतर कार्य अतित लेकिन स्थापित समस्याए सुस्पश्ट";
        assertEquals(expected, Fastu.decode(expected.getBytes("UTF-8")));

        expected = "因为无论你如何选择 年代出生的人都会书写常用的繁体汉字事实上 平话 了, 格 相反 为基础的书面语 在现代汉语的书面语中";
        assertEquals(expected, Fastu.decode(expected.getBytes("UTF-8")));
    }
}