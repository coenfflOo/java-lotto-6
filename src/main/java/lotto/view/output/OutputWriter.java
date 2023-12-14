package lotto.view.output;

sealed class OutputWriter
        permits ErrorOutputWriter, OutputView {

    OutputWriter() {
    }

    public static void println(Object object) {
        System.out.println(object);
    }

    public static void printNewLine() {
        System.out.println();
    }

    public static void printFormat(String format, Object object){
        System.out.printf(format,object);
    }
    public static void printFormat2(String format, Object object,Object object2){
        System.out.printf(format,object,object2);
    }
}