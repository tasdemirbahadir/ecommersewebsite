package com.btasdemir.dmall.commons.core.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.btasdemir.dmall.commons.core.domain.AuditEntity;
import com.btasdemir.dmall.commons.core.domain.BaseEntity;
import com.btasdemir.dmall.commons.core.domain.Category;
import com.btasdemir.dmall.commons.core.domain.Product;
import com.btasdemir.dmall.commons.core.domain.Role;
import com.btasdemir.dmall.commons.core.domain.User;
import com.btasdemir.dmall.commons.core.dto.AuditDto;
import com.btasdemir.dmall.commons.core.dto.BaseDto;
import com.btasdemir.dmall.commons.core.dto.CategoryDto;
import com.btasdemir.dmall.commons.core.dto.ProductDto;
import com.btasdemir.dmall.commons.core.dto.RoleDto;
import com.btasdemir.dmall.commons.core.dto.UserDto;

@Component
public class DtoUtils {

	// private static final Logger LOGGER =
	// LoggerFactory.getLogger(DtoUtils.class);

	// TO DTO UTILS

	@Autowired
	private DateUtils dateUtils;

	public <T extends BaseDto> BaseDto toBaseDto(BaseEntity entity, T readyBaseDto) {
		BaseDto baseDto = readyBaseDto != null ? readyBaseDto : new BaseDto();
		if (entity != null) {
			baseDto.setId(entity.getId());
		}
		return baseDto;
	}

	public <T extends AuditDto> AuditDto toAuditDto(AuditEntity auditEntity, T readyAuditDto) {
		if (auditEntity == null) {
			return null;
		}
		AuditDto auditDto = readyAuditDto != null ? readyAuditDto : new AuditDto();
		auditDto = (AuditDto) toBaseDto(auditEntity, auditDto);
		auditDto.setCrDate(dateUtils.toDateTime(auditEntity.getCrDate()));
		auditDto.setMoDate(dateUtils.toDateTime(auditEntity.getMoDate()));
		auditDto.setDeleted(auditEntity.getDeleted());

		return auditDto;
	}

	public CategoryDto toCategoryDto(Category category) {
		if (category == null) {
			return null;
		}
		CategoryDto categoryDto = new CategoryDto();

		categoryDto = (CategoryDto) toAuditDto(category, categoryDto);
		categoryDto.setCategoryKey(category.getCategoryKey());
		categoryDto.setName(category.getName());
		categoryDto.setDescription(category.getDescription());
		categoryDto.setParent(toCategoryDto(category.getParent()));
		return categoryDto;
	}

	public ProductDto toProductDto(Product product) {
		if (product == null) {
			return null;
		}
		ProductDto productDto = new ProductDto();

		productDto = (ProductDto) toAuditDto(product, productDto);
		productDto.setTitle(product.getTitle());
		productDto.setDescription(product.getDescription());
		productDto.setCategory(toCategoryDto(product.getCategory()));
		return productDto;
	}

	public RoleDto toRoleDto(Role role) {
		if (role == null) {
			return null;
		}
		RoleDto roleDto = new RoleDto();
		roleDto = (RoleDto) toBaseDto(role, roleDto);
		roleDto.setName(role.getName());
		roleDto.setDescription(role.getDescription());
		return roleDto;
	}

	public UserDto toUserDto(User user, DateUtils dateUtils) {
		if (user == null) {
			return null;
		}
		UserDto userDto = new UserDto();
		userDto = (UserDto) toAuditDto(user, userDto);
		userDto.setFirstName(user.getFirstName());
		userDto.setLastName(user.getLastName());
		userDto.setEmail(user.getEmail());
		userDto.setRole(toRoleDto(user.getRole()));
		return userDto;
	}

	// TO ENTITY UTILS

	public <T extends BaseEntity> BaseEntity toBaseEntity(BaseDto baseDto, T readyBaseEntity) {
		if (baseDto == null) {
			return null;
		}
		BaseEntity baseEntity = readyBaseEntity != null ? readyBaseEntity : new BaseEntity();
		baseEntity.setId(baseDto.getId());
		return baseEntity;
	}

	public <T extends AuditEntity> AuditEntity toAuditEntity(AuditDto auditDto, T readyAuditEntity) {
		if (auditDto == null) {
			return null;
		}
		AuditEntity auditEntity = readyAuditEntity != null ? readyAuditEntity : new AuditEntity();
		auditEntity = (AuditEntity) toBaseEntity(auditDto, auditEntity);
		auditEntity.setCrDate(dateUtils.toDate(auditDto.getCrDate()));
		auditEntity.setMoDate(dateUtils.toDate(auditDto.getMoDate()));
		auditEntity.setDeleted(auditDto.getDeleted());
		return auditEntity;
	}

	public Category toCategory(CategoryDto categoryDto) {
		if (categoryDto == null) {
			return null;
		}
		Category category = new Category();
		category = (Category) toAuditEntity(categoryDto, category);
		category.setCategoryKey(categoryDto.getCategoryKey());
		category.setName(categoryDto.getName());
		category.setDescription(categoryDto.getDescription());
		category.setParent(toCategory(categoryDto.getParent()));
		return category;
	}

	public Product toProduct(ProductDto productDto) {
		if (productDto == null) {
			return null;
		}
		Product product = new Product();
		product = (Product) toAuditEntity(productDto, product);
		product.setTitle(productDto.getTitle());
		product.setDescription(productDto.getDescription());
		product.setCategory(toCategory(productDto.getCategory()));
		return product;
	}

	public Role toRole(RoleDto roleDto) {
		if (roleDto == null) {
			return null;
		}
		Role role = new Role();
		role = (Role) toBaseEntity(roleDto, role);
		role.setName(roleDto.getName());
		role.setDescription(roleDto.getDescription());
		return role;
	}

	public User toUser(UserDto userDto) {
		if (userDto == null) {
			return null;
		}
		User user = new User();

		user = (User) toAuditEntity(userDto, user);
		user.setFirstName(userDto.getFirstName());
		user.setLastName(userDto.getLastName());
		user.setEmail(userDto.getEmail());
		user.setRole(toRole(userDto.getRole()));
		return user;
	}

}
