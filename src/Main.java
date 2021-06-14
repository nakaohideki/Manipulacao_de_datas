import java.util.Calendar;
public class Main
{
    public static void main(String[] args)
    {
        //Um cliente tem 10 dias após a data de vencimento para pagar sua fatura sem que sejam cobrados juros.
        //Caso esta data caia em um final de semana, o cliente pode pagar na segunda-feira seguinte.
        //Crie uma estrutura que receba uma data de vencimento e calcule quantos dias ele tem para pagar.

        Calendar vencimento = Calendar.getInstance();   //Instancia vencimento para guardar a data de vencimento.
        vencimento.set(2021, 05, 16);   //Ajustam os parâmetros do Calendar vencimento.
        int diaAnoVencimento = vencimento.get(06);  //Extrai e atribui na variável o dia do ano do vencimento.
        int tolerancia = 10;    //Atribui a tolerância em dias corridos para pagamento sem encargos.

        Calendar prazo = Calendar.getInstance();    //Instancia prazo para guardar a data de pagamento final.
        int diaAnoHoje = prazo.get(6);  //Atribui na variável o dia do ano da data atual.
        if(vencimento.before(prazo))    //Checa se a data de vencimento é posterior a data atual.
        {
            System.out.println("Vencimento não aceito.\nColocar data de vencimento posterior a hoje.");
            //Imprime menaviso.
        }
        else
        {
            prazo.add(Calendar.DATE, (diaAnoVencimento - diaAnoHoje + tolerancia));//Calcula o prazo de pagamento.
            switch (prazo.get(7))   //Checa o dia da semana do prazo para pagamento.
            {
                case 1: //Prazo para pagamento no domingo.
                prazo.add(Calendar.DATE, 1);    //Altera o prazo para o dia seguinte (segunda-feira).
                System.out.println("O cliente tem " + (diaAnoVencimento - diaAnoHoje + tolerancia + 1) + " dias " +
                "para pagar a fatura.\nO prazo final é:\n" + prazo.getTime());   //Imprime mensagem com aviso.
                break;  //Sai do switch.

                case 7: //Prazo para pagamento no sábado.
                prazo.add(Calendar.DATE, 2);    //Adicionam 2 dias ao prazo alterando para segunda-feira.
                System.out.println("O cliente tem " + (diaAnoVencimento - diaAnoHoje + tolerancia + 2) + " dias " +
                "para pagar a fatura.\nO prazo final é:\n" + prazo.getTime());   //Imprime mensagem com aviso.
                break;  //Sai do switch.

                default:    //Prazo para pagamento nos demais dias da semana.
                System.out.println("O cliente tem " + (diaAnoVencimento - diaAnoHoje + tolerancia) + " dias para" +
                " pagar a fatura.\nO prazo final para é:\n" + prazo.getTime());   //Imprime aviso.
                break;  //Sai do switch.
            }
        }
    }
}