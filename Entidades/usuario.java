public class Usuario{
    private int IdUsuario;
    private String nome;
    private List<Notas> notas = new ArrayList<>();

    public String getNome(){
      return this.nome;
    }

    public int IdUsuario(){
      return this.IdUsuario;
    }

    public List<Notas> getLista(){
      return this.notas;
    }

    private void setLista(List<Notas> notas){
      this.notas = notas;
    }
    
    private void addLista(Nota nota){
      this.notas.add(nota);
    }
}
