import turvo.CountryCode;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Supplier;
import java.util.regex.Pattern;

public class MainClass {

    private static final String PLACE_TYPE_DESC = " \u2022 3-digit postal code";

    public static void main(String[] args) throws IOException {

//        System.out.println("Hello" + PLACE_TYPE_DESC);
        Double val = Double.MAX_VALUE;
        System.out.println(val.isInfinite());
    }

    private static int testing() {
        Double val1 = 165.9d;
        Double val2 = 0.55d;
        System.out.println(multiplyExact(val1, val2).doubleValue());
        Number value = 91.245;
        BigDecimal bigDecimal = new BigDecimal(value.toString());
        bigDecimal = bigDecimal.setScale(2, RoundingMode.HALF_UP);
        System.out.println(bigDecimal.doubleValue());
        return 1;
    }

    private static Number multiplyExact(Number val1, Number val2) {
        BigDecimal bg1 = new BigDecimal(val1.toString());
        BigDecimal bg2 = new BigDecimal(val2.toString());
        BigDecimal result = bg1.multiply(bg2);
        if (result.scale() == 0) {
            try {
                return result.longValueExact();
            } catch (ArithmeticException var6) {
                return result.doubleValue();
            }
        } else {
            return result.doubleValue();
        }
    }

    private static void testOrElseThrow(){
        List<Double> rates = Arrays.asList(752262.0d);

        Double rate = resolveRate(rates)
                        .orElseThrow(couldNotResolveRateError());

        System.out.println(rate);
    }

    private static Supplier<RuntimeException> couldNotResolveRateError(
            ) {
        String errorMsg =
                String.format("Could not resolve rate for sequence %s", 1312);
        return () ->
                new IllegalArgumentException(
                        String.format("Unsupported sequence type %s", 1312));
    }

    private static Optional<Double> resolveRate(List<Double> list){
        return Optional.ofNullable(list.get(0));
    }

    public static class Test{
        public Test(){};

        public Child1 getChild1() {
            return child1;
        }

        private Child1 child1;
        private List<Integer> numbers;
        private String name;

    }

    public static class Child1{
        private Child2 child2;

        public Child2 getChild2() {
            return child2;
        }
    }

    public static class Child2{
        private String name;
    }

    private static void crTDIContract(){
        List<CountryCode> countryCodes =
                CountryCode.findByName(Pattern.compile("UNITED STATES", Pattern.CASE_INSENSITIVE));
        System.out.println(countryCodes.get(0).getAlpha2());
        System.out.println(countryCodes);
    }



    private static int AsyncMethod(){
        return 1;
    }



    public static class BaseClass implements TestIn{
    }
    public static class SuperClass extends BaseClass {
        ContractContext contractContext = new ContractContext();
    }
    public interface TestIn{};
    public static class ContractContext extends BaseClass{

        private String type;

        private String value;
    }

    private static void cr9266() throws IOException {
        File file = new File("/Users/aakashsandhyan/Downloads/newFolder/newTestFile.csv");
        OutputStream outputStream = new FileOutputStream(file);
        String x = "Hello";
        outputStream.write(x.getBytes(StandardCharsets.UTF_8));
        outputStream.close();
    }

    private static void cr8661(){

        List<Map<String, Object>> invitees = new ArrayList<>();
        Optional<String> email = null;
//        if(email.isPresent()){
//            System.out.print("hello");
//        }
        Map<String, Object> connection = new HashMap<>();
        Map<String, Object> contact = new HashMap<>();
        contact.put("email", "aakash@turvo.com");
        Map<String, Object> invitee1 = new HashMap<>();
//        invitee1.put("contact", contact);
        invitee1.put("_operation", 1);
        invitees.add(invitee1);
//        if(connection.containsKey("invitation")){
//            invitees = getList((Map<String, Object>) connection.get("invitation"), "invitees");
//            if(invitees.size() < 1){
//                return false;
//            }
//        }

        List<String> strings = Arrays.asList("aol.com", "att.net", "comcast.net", "facebook.com", "gmail.com", "gmx.com", "googlemail.com", "google.com", "hotmail.com", "hotmail.co.uk", "mac.com", "me.com", "mail.com", "msn.com", "live.com", "sbcglobal.net", "verizon.net", "yahoo.com", "yahoo.co.uk", "email.com", "fastmail.fm", "games.com", "gmx.net", "hush.com", "hushmail.com", "icloud.com", "iname.com", "inbox.com", "lavabit.com", "love.com", "outlook.com", "pobox.com", "protonmail.ch", "protonmail.com", "tutanota.de", "tutanota.com", "tutamail.com", "tuta.io", "keemail.me", "rocketmail.com", "safe-mail.net", "wow.com", "ygm.com", "ymail.com", "zoho.com", "yandex.com", "bellsouth.net", "charter.net", "cox.net", "earthlink.net", "juno.com", "btinternet.com", "virginmedia.com", "blueyonder.co.uk", "live.co.uk", "ntlworld.com", "orange.net", "sky.com", "talktalk.co.uk", "tiscali.co.uk", "virgin.net", "bt.com", "sina.com", "sina.cn", "qq.com", "naver.com", "hanmail.net", "daum.net", "nate.com", "yahoo.co.jp", "yahoo.co.kr", "yahoo.co.id", "yahoo.co.in", "yahoo.com.sg", "yahoo.com.ph", "163.com", "yeah.net", "126.com", "21cn.com", "aliyun.com", "foxmail.com", "hotmail.fr", "live.fr", "laposte.net", "yahoo.fr", "wanadoo.fr", "orange.fr", "gmx.fr", "sfr.fr", "neuf.fr", "free.fr", "gmx.de", "hotmail.de", "live.de", "online.de", "t-online.de", "web.de", "yahoo.de", "libero.it", "virgilio.it", "hotmail.it", "aol.it", "tiscali.it", "alice.it", "live.it", "yahoo.it", "email.it", "tin.it", "poste.it", "teletu.it", "bk.ru", "inbox.ru", "list.ru", "mail.ru", "rambler.ru", "yandex.by", "yandex.com", "yandex.kz", "yandex.ru", "yandex.ua", "ya.ru", "hotmail.be", "live.be", "skynet.be", "voo.be", "tvcablenet.be", "telenet.be", "hotmail.com.ar", "live.com.ar", "yahoo.com.ar", "fibertel.com.ar", "speedy.com.ar", "arnet.com.ar", "yahoo.com.mx", "live.com.mx", "hotmail.es", "hotmail.com.mx", "prodigy.net.mx", "yahoo.ca", "hotmail.ca", "bell.net", "shaw.ca", "sympatico.ca", "rogers.com", "yahoo.com.br", "hotmail.com.br", "outlook.com.br", "uol.com.br", "bol.com.br", "terra.com.br", "ig.com.br", "r7.com", "zipmail.com.br", "globo.com", "globomail.com", "oi.com.br");
        System.out.println(strings.get(0));
        System.out.println(strings.get(1));

        String emailId = invitees.stream()
                .filter(invitee -> (boolean) invitee.get("_operation").equals(0))
                .map(invitee -> (Map<String, Object>) invitee.get("contact"))
                .map(contact1 -> (String) contact1.get("email"))
                .findFirst()
                .orElse("");

        System.out.print(emailId);
//        if(emailId.isPresent() && emailId.get().contains("@")) {
//            domainName = emailId.get().split("@")[1];
//            validateDomainName(busId, account.getId(), domainName);
//      }
        }
}
