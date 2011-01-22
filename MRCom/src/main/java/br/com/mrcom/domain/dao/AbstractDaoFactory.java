package br.com.mrcom.domain.dao;

public abstract class AbstractDaoFactory {

    public static AbstractDaoFactory instance(Class<?> factory) {
        try {
            return (AbstractDaoFactory)factory.newInstance();
        } catch (Exception ex) {
            throw new RuntimeException("Couldn't create DAOFactory: " + factory);
        }
    }

    //Interfaces DAO

    public abstract EstadoDao getEstadoDao();
    public abstract ClienteDao getClienteDao();
    public abstract EnderecoDao getEnderecoDao();
}
