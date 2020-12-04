package br.com.trabalhofinal.LP3.constants;

public enum ErrorCodes {
	ADDITION_AND_FINES_NOT_FOUND("Addition And Fines Not Found"),
	PAYMENT_ACCOUNT_NOT_FOUND("Payment Account not found");

	private final String message;

	ErrorCodes(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}