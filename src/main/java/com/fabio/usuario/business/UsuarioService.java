package com.fabio.usuario.business;

import com.fabio.usuario.business.converter.UsuarioConverter;
import com.fabio.usuario.business.dto.UsuarioDTO;
import com.fabio.usuario.infrastructure.entity.Usuario;
import com.fabio.usuario.infrastructure.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    //injeção de dependências
    private final UsuarioRepository usuarioRepository;
    private final UsuarioConverter usuarioConverter;

    public UsuarioDTO salvarUsuario(UsuarioDTO usuarioDTO){
        Usuario usuario = usuarioConverter.paraUsuario(usuarioDTO);
        return usuarioConverter.paraUsuarioDTO(
                usuarioRepository.save(usuario)
        );
    }
}
