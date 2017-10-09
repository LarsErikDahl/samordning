package no.nav.samordning.vedtak;

public class VedtakDTO {
    private String test;
    private Integer testNummer;

    public VedtakDTO(String test, Integer testNummer) {
        this.test = test;
        this.testNummer = testNummer;
    }

    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }

    public Integer getTestNummer() {
        return testNummer;
    }

    public void setTestNummer(Integer testNummer) {
        this.testNummer = testNummer;
    }
}
