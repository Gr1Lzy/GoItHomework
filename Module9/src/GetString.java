public class GetString {
     public static String getString(Object[] elements, int size) {
        StringBuilder line = new StringBuilder("[");
        for (Object element : elements) {
            if (element == null) {
                if (size == 0) return "[]";
                line.append(" ");
                return line.toString().replace(",  ", "]");
            } else {
                line.append(element).append(", ");
            }

        }
        return "Error";
    }
}
