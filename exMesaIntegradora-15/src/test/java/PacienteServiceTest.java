import dao.ConfiguracaoJDBC;
import dao.impl.EnderecoDaoImpl;
import dao.impl.PacienteDaoImpl;
import model.Endereco;
import model.Paciente;
import org.junit.jupiter.api.Test;
import service.EnderecoService;
import service.PacienteService;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class PacienteServiceTest {
    private PacienteService pacienteService = new PacienteService(new PacienteDaoImpl(new ConfiguracaoJDBC()), new EnderecoService(new EnderecoDaoImpl(new ConfiguracaoJDBC())));


    @Test
    public void guardarPaciente(){
        Paciente paciente = new Paciente("Jose","Silva", "123464",  LocalDate.of(2021,3,3), new Endereco("rua das flores", 30, "Foz do Iguacu", "Paraná" ));
        pacienteService.salvar(paciente);
        assertTrue(paciente.getId() != null);
    }

    @Test
    public void pesquisarPaciente(){
        Paciente paciente = new Paciente("Jose","Silva", "123464",  LocalDate.of(2021,3,3), new Endereco("rua das flores", 30, "Foz do Iguacu", "Paraná" ));
        pacienteService.salvar(paciente);
        assertTrue(paciente.getId() != null);
        Paciente procurado = pacienteService.buscar(paciente.getId());
        assertTrue(procurado.getId() != null);
    }

}
