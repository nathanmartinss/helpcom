package com.helpcom.api.Producao;

import com.helpcom.api.Compra.Compra;
import com.helpcom.api.Compra.CompraRepository;
import com.helpcom.api.Ingrediente.Ingrediente;
import com.helpcom.api.Ingrediente.IngredienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProducaoService {
    @Autowired
    private CompraRepository compraRepository;

    @Autowired
    private IngredienteRepository ingredienteRepository;

    public Long calcularCusto(Long idReceita) {
        List<Ingrediente> ingredientes = ingredienteRepository.findByIdReceita(idReceita);
        long custoReceita = 0L;

        for (Ingrediente ingrediente : ingredientes) {
            Compra compraInfo = compraRepository.findFirstCompraInfo(ingrediente.getIdItem());

            if (compraInfo != null) {
                int qtdComprada = compraInfo.getQtdItem();
                int valorCompra = compraInfo.getValor();

                double proporcaoUtilizada = (double) ingrediente.getQtdIngrediente() / qtdComprada;
                int custoIngrediente = (int) (proporcaoUtilizada * valorCompra);

                custoReceita += custoIngrediente;
            }
        }
        return custoReceita;
    }

    public boolean verificarQuantidade(Long idReceita) {
        List<Ingrediente> ingredientes = ingredienteRepository.findByIdReceita(idReceita);

        for (Ingrediente ingrediente : ingredientes) {
            int qtdUtilizada = ingrediente.getQtdIngrediente();
            List<Compra> compras = compraRepository.findAllByIdItem(ingrediente.getIdItem());
            int qtdDisponivel = 0;

            for (Compra compra : compras) {
                qtdDisponivel += compra.getQtdItem();
            }
            if (qtdUtilizada > qtdDisponivel) {
                return false;
            }
        }
        return true;
    }
    public void atualizarQuantidades(Long idReceita) {
        List<Ingrediente> ingredientes = ingredienteRepository.findByIdReceita(idReceita);

        for (Ingrediente ingrediente : ingredientes) {
            int quantidadeNecessaria = ingrediente.getQtdIngrediente();
            Long idItem = ingrediente.getIdItem();

            List<Compra> compras = compraRepository.findAllByIdItemOrderByDataCompraAsc(idItem);

            for (Compra compra : compras) {
                int quantidadeAtual = compra.getQtdItem();


                if (quantidadeNecessaria <= quantidadeAtual) {
                    compraRepository.updateQuantidadeItem(compra.getIdItem(), quantidadeAtual - quantidadeNecessaria);


                    if (quantidadeAtual == quantidadeNecessaria) {
                        compraRepository.deleteById(compra.getId());
                    }
                    break;
                } else {
                    compraRepository.deleteById(compra.getId());
                    quantidadeNecessaria -= quantidadeAtual;

                }
            }
        }
    }
}
