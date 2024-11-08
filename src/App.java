
import dao.*;
import domain.*;
import java.util.*;
import java.time.*;

public class App {
    public static void main(String[] args) throws Exception {
        Especie cachorro = new Especie("Cachorro");
        EspecieDao especieDao = new EspecieDao();
        especieDao.inserir(cachorro);
        System.out.println(cachorro);

        AtendenteDao atendenteDao = new AtendenteDao();
        Atendente atendente = new Atendente(2000d);
        atendenteDao.inserir(atendente);
        System.out.println(atendente);

        ClienteDao clienteDao = new ClienteDao();
        Cliente cliente = new Cliente("Carlos", atendente);
        LocalDate dataNascimento = LocalDate.of(2010, 10, 10);
        Pet pet = new Pet("Layca", dataNascimento, GeneroEnum.FEMEA, cliente, cachorro);
        cliente.setPets(Arrays.asList(pet));
        clienteDao.inserir(cliente);
        System.out.println(cliente);
        System.out.println(cliente.getPets());

        VeterinarioDao veterinarioDao = new VeterinarioDao();
        Veterinario veterinario = new Veterinario("Dra. Camila");
        veterinarioDao.inserir(veterinario);
        System.out.println(veterinario);

        TratamentoDao tratamentoDao = new TratamentoDao();
        Tratamento tratamento = new Tratamento("Caroço na pata", veterinario);
        tratamentoDao.inserir(tratamento);
        System.out.println(tratamento);

        ConsultaDao consultaDao = new ConsultaDao();
        Consulta consulta = new Consulta("Detectado caroço na pata",LocalDateTime.now(),  tratamento, veterinario);
        consultaDao.inserir(consulta);
        System.out.println(consulta);

        ExameDao exameDao = new ExameDao();
        Exame exame = new Exame("Biópsia", "Falso Negativo", LocalDate.now(), consulta);
        exameDao.inserir(exame);
        System.out.println(exame);
    }
}
