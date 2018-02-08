package com.btasdemir.dmall.commons.core.dto;

import com.btasdemir.dmall.commons.core.domain.Category;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@NoArgsConstructor
@RequiredArgsConstructor
public class CategoryDto extends AuditDto {

	private static final long serialVersionUID = -6594861659946573276L;
	
	@NonNull private String categoryKey;
	@NonNull private String name;
	private String description;
	private CategoryDto parent;
	private Long parentCategoryId;
	private String persistError;
	
	public boolean equalsToCategory(Category category) {
		if (category == null) {
			return false;
		}
		return equals(this.getId(), category.getId())
				&& equals(this.getCrDate(), category.getCrDate())
				&& equals(this.getMoDate(), category.getMoDate())
				&& equals(this.getCategoryKey(), category.getCategoryKey())
				&& equals(this.getName(), category.getName())
				&& equals(this.getDescription(), category.getDescription())
				&& equalsCategories(this.getParent(), category.getParent());
	}
	
	private boolean equals(Object o1, Object o2) {
		if (o1 == null) {
			return o2 == null;
		}
		return o2 != null && o1.equals(o2);
	}
	
	private boolean equalsCategories(CategoryDto catDto, Category cat) {
		if (catDto == null) {
			return cat == null;
		}
		return catDto != null && catDto.equalsToCategory(cat);
	}

}
