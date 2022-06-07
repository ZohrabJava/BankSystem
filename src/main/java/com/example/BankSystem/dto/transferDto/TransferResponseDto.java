package com.example.BankSystem.dto.transferDto;

import com.example.BankSystem.enams.TransferState;

import java.time.LocalDateTime;

public class TransferResponseDto {
    String transferFromCard;
    Double amount;
    TransferState transferState;
    LocalDateTime localDateTime;
    Double balance;

    public TransferResponseDto(String transferFromCard, Double amount, TransferState transferState, LocalDateTime localDateTime, Double balance) {
        this.transferFromCard = transferFromCard;
        this.amount = amount;
        this.transferState = transferState;
        this.localDateTime = localDateTime;
        this.balance = balance;
    }

    public TransferResponseDto() {
    }

    public String getTransferFromCard() {
        return transferFromCard;
    }

    public void setTransferFromCard(String transferFromCard) {
        this.transferFromCard = transferFromCard;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public TransferState getTransferState() {
        return transferState;
    }

    public void setTransferState(TransferState transferState) {
        this.transferState = transferState;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }
}
