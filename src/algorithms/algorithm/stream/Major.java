package algorithms.algorithm.stream;

public enum Major {

    ECONOMICS("경제학과"),
    POLITICS("정치학과"),
    PSYCHOLOGY("체육학과"),
    EDUCATION("교육학과"),
    LAWS("법학과"),
    COMPUTER("컴퓨터공학과");

    private final String majorName;

    Major(String majorName) {
        this.majorName = majorName;
    }

    public String getMajorName() {
        return this.majorName;
    }

    public static Major findByMajorName(String majorName) {
        for (Major major : Major.values()) {
            if (major.getMajorName().equals(majorName)) {
                return major;
            }
        }
        throw new IllegalArgumentException("No major with name: " + majorName);
    }
}
