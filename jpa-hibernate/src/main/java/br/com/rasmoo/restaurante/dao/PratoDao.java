package br.com.rasmoo.restaurante.dao;

import br.com.rasmoo.restaurante.entity.Cardapio;

import javax.persistence.EntityManager;

public class PratoDao {

    private EntityManager entityManager;

    public PratoDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void cadastrar(final Cardapio prato) {
        this.entityManager.persist(prato);
        System.out.println("Entidade Cadastrada: " + prato);
    }

    public Cardapio consultar(final Integer id) {
        return this.entityManager.find(Cardapio.class, id);
    }

    public void atualizar(final Cardapio prato) {
        this.entityManager.merge(prato);
    }
    public void excluir(final Cardapio prato){
        this.entityManager.remove(prato);
    }

}