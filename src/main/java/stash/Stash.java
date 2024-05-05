//package stash;
//
//import io.qameta.allure.Allure;
//import org.testng.Assert;
//
//import java.util.regex.Matcher;
//import java.util.regex.Pattern;
//
///**
// * Временное хранение и передача данных между классами
// */
//public class Stash {
//    private static final ThreadLocal<ThreadStash> stashes = new ThreadLocal<>();
//
//    private static ThreadStash getStash() {
//        ThreadStash current = stashes.get();
//        if (current == null) {
//            ThreadStash stash = new ThreadStash();
//            stashes.set(stash);
//            return stash;
//        }
//        return current;
//    }
//
//    /** Очищение Stash */
//    public static void clearStash() {
//        stashes.set(null);
//    }
//
//    public static void put(String key, Object value) {
//        getStash().put(key, value);
//        Allure.addAttachment("Запоминаем переменную: " + key, (value != null) ? value.toString() : "null");
//    }
//
//    public static Object get(String key) {
//        return getOrDefault(key, null);
//    }
//
//    public static void clear() {
//        getStash().clear();
//    }
//
//    public static Object getOrDefault(String key, Object defaultValue) {
//        return getStash().getOrDefault(key, defaultValue);
//    }
//
//    public static Object getNotNull(String key) {
//        Object o = get(key);
//        Assert.assertNotNull(o, "Значение переменной по ключу '" + key + "' пустое");
//        return o;
//    }
//
//    /**
//     * Замена в строке всех переменных значениями из стеша по маске ${ИмяКлюча в стеше}
//     * @param input
//     * @return
//     */
//    public static String enrich(String input) {
//        Matcher m = Pattern.compile("\\$\\{([^}]+)}").matcher(input);
//        while (m.find()) {
//            input = input.replace("${" + m.group(1) + "}", getNotNull(m.group(1).toString()).toString());
//        }
//        return input;
//    }
//
//    /**
//     * Проверка на существование значения с ключом
//     * @param key
//     */
//    public static void check(String key) {
//        Assert.assertNotNull(getOrDefault(key, null), "Значение по ключу '" + key + "' не найдено");
//    }
//}
