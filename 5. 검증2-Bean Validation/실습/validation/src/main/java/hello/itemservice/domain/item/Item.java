package hello.itemservice.domain.item;

import lombok.Data;
import org.hibernate.validator.constraints.Range;
import org.hibernate.validator.constraints.ScriptAssert;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

// @ScriptAssert 같은 경우 제약이 많고 복잡함. 실무에서는 검증 기능이 해당 객체의 범위를 넘어서는 경우도 있어 대응이 어려움
@Data
//@ScriptAssert(lang = "javascript", script = "_this.price * _this.quantity >= 10000", message="총합이 10000원 이상이 되게 해주세요")
public class Item {

    private Long id;

    @NotBlank
    private String itemName;

    @NotNull
    @Range(min = 1000, max = 1000000)
    private Integer price;

    @NotNull
    @Max(9999)
    private Integer quantity;

    public Item() {
    }

    public Item(String itemName, Integer price, Integer quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }
}
