package br.com.rasmoo.restaurante.service.test;

import br.com.rasmoo.restaurante.dao.CardapioDao;
import br.com.rasmoo.restaurante.dao.CategoriaDao;
import br.com.rasmoo.restaurante.entity.Cardapio;
import br.com.rasmoo.restaurante.entity.Categoria;
import br.com.rasmoo.restaurante.util.JPAUtil;

import javax.persistence.EntityManager;
import java.math.BigDecimal;

public class CardapioService {
    public static void main(String[] args) {

        EntityManager entityManager = JPAUtil.getEntityManagerRasFood();
        cadastrarProdutoCardapio(entityManager, cadastrarCategoria(entityManager));

    }

    private static Categoria cadastrarCategoria(EntityManager entityManager) {
        CategoriaDao categoriaDao = new CategoriaDao(entityManager);
        Categoria pratoPrincipal = new Categoria("Prato Principal");
        entityManager.getTransaction().begin();
        categoriaDao.cadastrar(pratoPrincipal);
        entityManager.getTransaction().commit();
        entityManager.clear();
        return pratoPrincipal;
    }

    private static void cadastrarProdutoCardapio(EntityManager entityManager, Categoria categoria) {


        //teste
        Cardapio risoto = new Cardapio();
        risoto.setNome("Risoto de frutos do mar");
        risoto.setDescricao("Risoto acompanhado de lula, polvo e mariscos.");
        risoto.setDisponivel(true);
        risoto.setCategoria(categoria);
        risoto.setValor(BigDecimal.valueOf(88.50));

        Cardapio salmao = new Cardapio();
        salmao.setNome("Salmao ao molho de maracuja");
        salmao.setDescricao("Salmao grelhado ao molho de maracuja");
        salmao.setDisponivel(true);
        risoto.setCategoria(categoria);
        salmao.setValor(BigDecimal.valueOf(60.00));

        CardapioDao cardapioDao = new CardapioDao(entityManager);

        entityManager.getTransaction().begin();

        cardapioDao.cadastrar(risoto);
        entityManager.flush();
        cardapioDao.cadastrar(salmao);


//        cardapioDao.excluir(risoto);

        System.out.println("O prato consultado foi: " + cardapioDao.consultar(16));

//        risoto.setValor(BigDecimal.valueOf(75.60));
//        cardapioDao.atualizar(risoto);

        System.out.println("O prato consultado foi: " + cardapioDao.consultar(1));
        entityManager.close();


    }

}
