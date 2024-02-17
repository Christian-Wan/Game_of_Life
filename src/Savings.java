public class Savings {
    private double saved, retirement, job, studentLoan, rent, rentalInsurance, streamingServices, internet, groceries, dataPlan, commutingCost, extra;
    private int month, debtYears;
    private boolean badMonth;
    public Savings() {
        month = 0;
        saved = 0;
        retirement = 0;
        job = 75000;
        studentLoan = 0;
        rent = 0;
        rentalInsurance = 0;
        streamingServices = 0;
        internet = 50;
        groceries = 0;
        dataPlan = 50;
        commutingCost = 165;
        extra = 100;
        debtYears = 0;
        badMonth = false;
    }

    public Savings(double job, double studentLoan, double rent, double rentalInsurance, double streamingServices, double internet, double groceries, double dataPlan, double commutingCost, double extra, int debtYears) {
        saved = 0;
        retirement = 0;
        this.job = job;
        this.studentLoan = studentLoan;
        this.rent = rent;
        this.rentalInsurance = rentalInsurance;
        this.streamingServices = streamingServices;
        this.internet = internet;
        this.groceries = groceries;
        this.dataPlan = dataPlan;
        this.commutingCost = commutingCost;
        this.extra = extra;
        this.month = 0;
        this.debtYears = debtYears;
        badMonth = false;
    }

    public void updateCosts() {
        job = (Math.round(job * (1 + ((int) (Math.random() * 3) + 5) / 100.0) * 100.0) / 100.0);
        rent = (Math.round(rent * (1 + ((int) (Math.random() * 3) + 3) / 100.0) * 100.0) / 100.0);
        rentalInsurance = (Math.round(rentalInsurance * (1 + ((int) (Math.random() * 3) + 3) / 100.0) * 100.0) / 100.0);
        streamingServices = (Math.round(streamingServices * (1 + ((int) (Math.random() * 3) + 3) / 100.0) * 100.0) / 100.0);
        internet = (Math.round(internet * (1 + ((int) (Math.random() * 3) + 3) / 100.0) * 100.0) / 100.0);
        groceries = (Math.round(groceries * (1 + ((int) (Math.random() * 3) + 3) / 100.0) * 100.0) / 100.0);
        dataPlan = (Math.round(dataPlan * (1 + ((int) (Math.random() * 3) + 3) / 100.0) * 100.0) / 100.0);
        commutingCost = (Math.round(commutingCost * (1 + ((int) (Math.random() * 3) + 3) / 100.0) * 100.0) / 100.0);
    }

    public void updateSavings() {
        saved += (job / 12) * .4 - studentLoan - rent - rentalInsurance - streamingServices - internet - groceries - dataPlan - commutingCost - extra;
        retirement += (job / 12) * .1;
        saved = Math.round(saved * 100.0) / 100.0;
        retirement = Math.round(retirement * 100.0) / 100.0;
        month++;
        if (month == debtYears * 12) {
            studentLoan = 0;
        }
    }

    public void unfortunate() {
        if ((int) (Math.random() * 5) == 1) {
            saved -= 150;
            badMonth = true;
        }
        else {
            badMonth = false;
        }
    }

    public double getSaved() {
        return saved;
    }

    public int getMonth() {
        return month;
    }

    public String toString() {
        String result = "Month " + month + "-------------------------" +
                "\nSaved: $" + saved + "     In Retirement: $" + retirement +
                "\nEarning: $" + Math.round((job / 12) * .4 * 100.0) / 100.0 +
                "\nCost of Living: $" + (studentLoan + rent + rentalInsurance + streamingServices + internet + groceries + dataPlan + commutingCost + extra);
        if (studentLoan == 0) {
            result += "\nStudent Loan Debt: Paid";
        }
        else {
            result += "\nStudent Loan Debt: Unpaid";

        }
        if (badMonth) {
            result += "\nUnlucky month -$150";
        }
        return result;
    }
}