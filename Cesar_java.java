package Main.src;

import java.util.Arrays;
import java.util.List;

// Essa classe serve para criptografar a mensagem com base na lista
// Sei que é possivel usar o Char e com isso trabalhar com Unicode
// porem seria facil e preferir fazer assim
public class CifraCesar {

    List<String> lista = Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p",
            "q", "r", "s", "t", "u", "v", "x", "w", "y", "z", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9");

    /**
     * Passando o indice, sendo maior que lista ele começa a pegar do incio e sendo
     * menor, começa a pegar do fim esse metodo impedi de lançar uma
     * IndexOfboundException
     *
     * @param indice indice que vai acessar lista
     * @return retorna uma letra de lista ja trocada
     */
    private String pegar_letra(int indice) {
        // Lista tem 36 elementos
        // qualquer valor < 0, recebe 36, ou seja, -2+36=34
        // qualquer valor >= 36, retiro 36 ou seja, 38-36=2 / 36-36=0
        // valores entre 0 e 35 nao cai no if

        if (indice < 0) {
            return this.lista.get(indice + lista.size());
        } else if (indice >= lista.size()) {
            return this.lista.get(indice - lista.size());
        }

        return this.lista.get(indice);
    }

    /**
     * Esse metodo criptografa a msg Modo 0 = Criptografia Modo 1 = Descriptografia
     *
     * @param chave posiçao de n casas que vai para frente ou para traz
     * @param msg   a mensagem que vai ser criptografada
     * @param modo  se vai criptografar ou descriptografar
     * @return retorna a msg criptografada
     */
    private String criptografia(int chave, String msg, int modo) {
        String mensagem = msg.toLowerCase();
        StringBuilder msgCriptografada = new StringBuilder();

        for (int indice = 0; indice < mensagem.length(); indice++) {

            Character temp = mensagem.charAt(indice);
            int numero = lista.indexOf(temp.toString());

            // Caso nao esteja na lista, o indexOf retorna -1, com isso
            // ja add direto a msgCriptografada
            if (numero == -1) {
                msgCriptografada.append(temp);
                continue;
            }

            if (modo == 0) {
                // Criptografar
                msgCriptografada.append(pegar_letra(numero + chave));
            } else {
                // Descrptografar
                msgCriptografada.append(pegar_letra(numero - chave));
            }

        }

        return msgCriptografada.toString();
    }

    public String criptografar(int chave, String msg) {
        return this.criptografia(chave, msg, 0);
    }

    public String descriptografar(int chave, String msg) {
        return this.criptografia(chave, msg, 1);
    }
    
    //novo teste
}
