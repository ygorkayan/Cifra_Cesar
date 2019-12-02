class Cesar:
    def __init__(self):
        self.alfabeto = ["a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m",
                         "n", "o", "p", "q", "r", "s", "t", "u", "v", "x", "w", "y", "z",
                         "0", "1", "2", "3", "4", "5", "6", "7", "8", "9"]

    # esse metodo é responsavel por nao deixar acessar
    # indices que nao estao na lista
    def __pega_letra(self, numero):
        if numero < len(self.alfabeto):
            return self.alfabeto[numero]
        else:
            return self.alfabeto[numero - len(self.alfabeto)]

    # o algoritimo que criptografa é esse
    def __criptografia(self, chave, msg, modo):

        # Modo 0 = Criptografar
        # Modo 1 = Descriptografar

        msg = msg.lower() 
        msg_criptografada = ""

        for letra in msg:
            if letra in self.alfabeto:
                numero = self.alfabeto.index(letra)

                if modo == 0:           # Verifica o modo de Criptografia
                    numero += chave     # e com isso, vai N casas para frente
                else:                   # 
                    numero -= chave     # ou vai N casas para traz

                msg_criptografada += self.__pega_letra(numero)
            else:
                msg_criptografada += letra

        print(msg_criptografada)

    def criptografar(self, chave, msg):
        self.__criptografia(chave, msg, 0)

    def descriptografar(self, chave, msg):
        self.__criptografia(chave, msg, 1)