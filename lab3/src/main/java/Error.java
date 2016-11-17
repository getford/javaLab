public class Error {
    private String error;

    String errors(String code) {
        switch (code) {
            case "ERROR_LOGIN":
                setError("ЛОГИН НЕ ДОЛЖЕН ИМЕТЬ ЦИФР");
                break;
            case "ERROR_LOGIN_LENGHT":
                setError("Логин привышает максимально дупустимую длину");
                break;
            case "ERROR_PASSWORD":
                setError("Не верный пароль");
                break;
            case "ERROR_CASH_NULL":
                setError("Сумма вашего счета 0");
                break;
            case "ERROR_CASH":
                setError("Сумма на вашем счету отрицательна");
                break;
            case "ERROR_PAY":
                setError("Недостаточно средств для оплаты");
                break;
            case "ERROR_NUM_CARD":
                setError("Запрошеная карта не является вашей, либо недоступна");
                break;
        }
        return getError();
    }

    public String getError() {
        return error;
    }

    private void setError(String error) {
        this.error = error;
    }
}
