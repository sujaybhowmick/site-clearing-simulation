package com.sujay.simulator.costing;

public class CostReportGenerator {

    public void renderReport(CostReport costReport) {
        String header = "Item                                                 Quantity   Cost";
        System.out.println(padStringWithSpaces(header));
        int total = 0;
        for (CostReportItem costReportItem: costReport.getItems()) {
            String detail = "%s%d     %d\n";
            System.out.printf(detail, padStringWithSpaces(costReportItem.getDescription()),
                    costReportItem.getQuantity(), costReportItem.getCost());
            total = total + costReportItem.getCost();
        }
        String footer = "Total                                                            %d\n";
        System.out.println("--------------------------------------------------------------------");
        System.out.printf(footer, total);
    }

    private String padStringWithSpaces(String str) {
        return str + " ".repeat(Math.max(0, 60 - str.length()));
    }
}
