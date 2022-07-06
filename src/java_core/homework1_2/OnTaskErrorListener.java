package java_core.homework1_2;

@FunctionalInterface
public interface OnTaskErrorListener {
    void onError(String error);
}
