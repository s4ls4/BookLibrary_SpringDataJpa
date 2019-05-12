package web.dto;

import lombok.*;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString(callSuper = true)
@Builder
public class BookDto extends BaseDto {
    private String serialNumber;
    private String name;
    private String author;
    private int price;
}
