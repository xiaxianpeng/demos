package escape;

public class EscapeTest {
    public static SomeClass someClass;

    /**
     * 全局变量赋值逃逸
     */
    public void globalVariablePointerEscape() {
        someClass = new SomeClass();
    }


    /**
     * 方法返回值逃逸（作用域由methodPointerEscape逃逸到someClass）
     * someClass() {
     * SomeClass someClass = methodPointerEscape();
     * }
     */
    public SomeClass methodPointerEscape() {
        return new SomeClass();
    }

    /**
     * 实例引用传递逃逸
     * this 逃逸到 someClass作用域
     */
    public void instancePassPointerEscape() {
        this.methodPointerEscape().printClassName(this);
    }

    public static class SomeClass {
        public void printClassName(EscapeTest escapeTest) {
            System.out.println(escapeTest.getClass().getName());
        }
    }
}
