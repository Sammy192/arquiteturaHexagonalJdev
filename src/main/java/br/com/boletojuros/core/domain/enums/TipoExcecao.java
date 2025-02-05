package br.com.boletojuros.core.domain.enums;

public enum TipoExcecao {
    BOLETO_INVALIDO {
        @Override
        public String getMensagemErro() {
            return "O boleto encontrado é inválido";
        }
    },
    TIPO_BOLETO_INVALIDO {
        @Override
        public String getMensagemErro() {
            return "O tipo do boleto é inválido. Cálculo de juros disponível apenas para boletos XPTO.";
        }
    },
    BOLETO_NAO_VENCIDO {
        @Override
        public String getMensagemErro() {
            return "Boleto não vencido";
        }
    },
    CONTEUDO_INVALIDO {
        @Override
        public String getMensagemErro() {
            return "Conteudo inválido";
        }
    };

    public abstract String getMensagemErro();
}
