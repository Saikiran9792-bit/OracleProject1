package utils;

class ScreenshotData {
    String imagePath;
    String testName;
    String className;
    String step;
    String status;

    public ScreenshotData(String imagePath, String testName, String className, String step, String status) {
        this.imagePath = imagePath;
        this.testName = testName;
        this.className = className;
        this.step = step;
        this.status = status;
    }
}