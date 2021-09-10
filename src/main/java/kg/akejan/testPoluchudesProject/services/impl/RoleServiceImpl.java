package kg.akejan.testPoluchudesProject.services.impl;

import kg.akejan.testPoluchudesProject.dao.RoleRepository;
import kg.akejan.testPoluchudesProject.mappers.RoleMapper;
import kg.akejan.testPoluchudesProject.models.dto.RoleDto;
import kg.akejan.testPoluchudesProject.services.RoleService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    private RoleRepository roleRepository;
    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    RoleMapper roleMapper = RoleMapper.ROLE_MAPPER;

    @Override
    public RoleDto save(RoleDto roleDto) {
        return roleMapper.toDto(roleRepository.save(roleMapper.toEntity(roleDto)));
    }

    @Override
    public RoleDto update(RoleDto roleDto) {
        return null;
    }

    @Override
    public List<RoleDto> findAll() {
        return null;
    }

    @Override
    public RoleDto findById(Long aLong) {
        return null;
    }

    @Override
    public RoleDto deactivate(Long aLong) {
        return null;
    }
}
