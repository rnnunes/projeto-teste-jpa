package br.com.rasmoo.restaurante.dao;

import br.com.rasmoo.restaurante.entity.Cardapio;

import javax.persistence.EntityManager;
import java.util.List;

public class CardapioDao {

    private EntityManager entityManager;

    public CardapioDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void cadastrar(final Cardapio prato) {
        this.entityManager.persist(prato);
        System.out.println("Entidade Cadastrada: " + prato);
    }

    public Cardapio consultarPorID(final Integer id) {
        return this.entityManager.find(Cardapio.class, id);
    }

    public List<Cardapio> ConsultarTodos() {
        String sql = "SELECT c FROM Cardapio c";
        return this.entityManager.createQuery(sql, Cardapio.class).getResultList();
    }

    public void atualizar(final Cardapio prato) {
        this.entityManager.merge(prato);
    }
    public void excluir(final Cardapio prato){
        this.entityManager.remove(prato);
    }

}
