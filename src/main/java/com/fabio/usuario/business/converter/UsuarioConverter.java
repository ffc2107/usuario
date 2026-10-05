package com.fabio.usuario.business.converter;

import com.fabio.usuario.business.dto.EnderecoDTO;
import com.fabio.usuario.business.dto.TelefoneDTO;
import com.fabio.usuario.business.dto.UsuarioDTO;
import com.fabio.usuario.infrastructure.entity.Endereco;
import com.fabio.usuario.infrastructure.entity.Telefone;
import com.fabio.usuario.infrastructure.entity.Usuario;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UsuarioConverter {

    public Usuario paraUsuario(UsuarioDTO usuarioDTO) {

        return Usuario.builder()
                .nome(usuarioDTO.getNome())
                .email(usuarioDTO.getEmail())
                .senha(usuarioDTO.getSenha())
                .enderecos(paraListaEndereco(usuarioDTO.getEnderecos()))
                .telefones(paraListaTelefone(usuarioDTO.getTelefones()))
                .build();

        //ou
        /*Usuario usuario = new Usuario();
        usuario.setNome(usuarioDTO.getNome());
        usuario.setEmail(usuarioDTO.getEmail());
        usuario.setSenha(usuarioDTO.getSenha());
        usuario.setEnderecos(paraListaEndereco(usuarioDTO.getEnderecos()));
        usuario.setTelefones(paraListaTelefone(usuarioDTO.getTelefones()));

        return usuario;*/
    }

    public List<Endereco> paraListaEndereco(List<EnderecoDTO> enderecosDTOS){

        return enderecosDTOS.stream().map(this::paraEndereco).toList();

//        ou

        /*List<Endereco> enderecos = new ArrayList<>();
        for (EnderecoDTO enderecosDTO : enderecosDTOS) {
            enderecos.add(paraEndereco(enderecosDTO));
        }
        return enderecos;*/

    }

    public Endereco paraEndereco(EnderecoDTO enderecoDTO){
        return Endereco.builder()
                .rua(enderecoDTO.getRua())
                .numero(enderecoDTO.getNumero())
                .cidade(enderecoDTO.getCidade())
                .complemento(enderecoDTO.getComplemento())
                .cep(enderecoDTO.getCep())
                .estado(enderecoDTO.getEstado())
                .build();
    }

    public List<Telefone> paraListaTelefone(List<TelefoneDTO> telefoneDTOS){
        return telefoneDTOS.stream().map(this::paraTelefone).toList();

        /*ou
        List<Telefone> telefones = new ArrayList<>();
        for (TelefoneDTO telefoneDTO : telefoneDTOS) {
            telefones.add(paraTelefone(telefoneDTO));
        }
        return telefones;*/

    }

    public Telefone paraTelefone(TelefoneDTO telefoneDTO){
        return Telefone.builder()
                .numero(telefoneDTO.getNumero())
                .ddd(telefoneDTO.getDdd())
                .build();
    }



    public UsuarioDTO paraUsuarioDTO(Usuario usuarioDTO) {

        return UsuarioDTO.builder()
                .nome(usuarioDTO.getNome())
                .email(usuarioDTO.getEmail())
                .senha(usuarioDTO.getSenha())
                .enderecos(paraListaEnderecoDTO(usuarioDTO.getEnderecos()))
                .telefones(paraListaTelefoneDTO(usuarioDTO.getTelefones()))
                .build();

        //ou
        /*UsuarioDTO usuarioDTO2 = new UsuarioDTO();
        usuarioDTO2.setNome(usuarioDTO.getNome());
        usuarioDTO2.setEmail(usuarioDTO.getEmail());
        usuarioDTO2.setSenha(usuarioDTO.getSenha());
        usuarioDTO2.setEnderecos(paraListaEnderecoDTO(usuarioDTO.getEnderecos()));
        usuarioDTO2.setTelefones(paraListaTelefoneDTO(usuarioDTO.getTelefones()));
        return usuarioDTO2;*/
    }

    public List<EnderecoDTO> paraListaEnderecoDTO(List<Endereco> enderecosDTOS){

        return enderecosDTOS.stream().map(this::paraEnderecoDTO).toList();

//        ou

        /*List<Endereco> enderecos = new ArrayList<>();
        for (EnderecoDTO enderecosDTO : enderecosDTOS) {
            enderecos.add(paraEndereco(enderecosDTO));
        }
        return enderecos;*/

    }

    public EnderecoDTO paraEnderecoDTO(Endereco enderecoDTO){
        return EnderecoDTO.builder()
                .rua(enderecoDTO.getRua())
                .numero(enderecoDTO.getNumero())
                .cidade(enderecoDTO.getCidade())
                .complemento(enderecoDTO.getComplemento())
                .cep(enderecoDTO.getCep())
                .estado(enderecoDTO.getEstado())
                .build();
    }

    public List<TelefoneDTO> paraListaTelefoneDTO(List<Telefone> telefoneDTOS){
        return telefoneDTOS.stream().map(this::paraTelefoneDTO).toList();

        /*ou
        List<Telefone> telefones = new ArrayList<>();
        for (TelefoneDTO telefoneDTO : telefoneDTOS) {
            telefones.add(paraTelefone(telefoneDTO));
        }
        return telefones;*/

    }

    public TelefoneDTO paraTelefoneDTO(Telefone telefoneDTO){
        return TelefoneDTO.builder()
                .numero(telefoneDTO.getNumero())
                .ddd(telefoneDTO.getDdd())
                .build();
    }

    public Usuario updateUsuario(UsuarioDTO usuarioDTO, Usuario usuarioEntity) {
        return Usuario.builder()
                .nome(usuarioDTO.getNome() != null ? usuarioDTO.getNome() : usuarioEntity.getNome())
                .id(usuarioEntity.getId())
                .senha(usuarioDTO.getSenha() != null ? usuarioDTO.getSenha() : usuarioEntity.getSenha())
                .email(usuarioDTO.getEmail() != null ? usuarioDTO.getEmail() : usuarioEntity.getEmail())
                .enderecos(usuarioEntity.getEnderecos())
                .telefones(usuarioEntity.getTelefones())
                .build();
    }
}
