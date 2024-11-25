package com.example.autoparkmanager.models;

import java.time.LocalDate;

public class Report {
    private LocalDate date; // Fecha del reporte
    private double totalIncome; // Total de ingresos
    private double totalExpenses; // Total de gastos
    private double balance; // Balance neto
    private String description; // Descripción adicional

    // Constructor completo
    public Report(LocalDate date, double totalIncome, double totalExpenses, double balance, String description) {
        this.date = date;
        this.totalIncome = totalIncome;
        this.totalExpenses = totalExpenses;
        this.balance = balance;
        this.description = description;
    }

    // Constructor vacío (opcional, por si se necesita un objeto vacío)
    public Report() {}

    // Getters y Setters
    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public double getTotalIncome() {
        return totalIncome;
    }

    public void setTotalIncome(double totalIncome) {
        this.totalIncome = totalIncome;
    }

    public double getTotalExpenses() {
        return totalExpenses;
    }

    public void setTotalExpenses(double totalExpenses) {
        this.totalExpenses = totalExpenses;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    // Método para calcular el balance basado en ingresos y gastos
    public void calculateBalance() {
        this.balance = this.totalIncome - this.totalExpenses;
    }

    // Método para representar el reporte como texto (útil para depuración)
    @Override
    public String toString() {
        return "Report{" +
                "date=" + date +
                ", totalIncome=" + totalIncome +
                ", totalExpenses=" + totalExpenses +
                ", balance=" + balance +
                ", description='" + description + '\'' +
                '}';
    }
}
