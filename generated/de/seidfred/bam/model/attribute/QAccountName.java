package de.seidfred.bam.model.attribute;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QAccountName is a Querydsl query type for AccountName
 */
@Generated("com.mysema.query.codegen.EmbeddableSerializer")
public class QAccountName extends BeanPath<AccountName> {

    private static final long serialVersionUID = -546739528L;

    public static final QAccountName accountName = new QAccountName("accountName");

    public final de.seidfred.bam.rdm.QStringValueObject _super = new de.seidfred.bam.rdm.QStringValueObject(this);

    //inherited
    public final BooleanPath nullOrEmpty = _super.nullOrEmpty;

    //inherited
    public final StringPath value = _super.value;

    public QAccountName(String variable) {
        super(AccountName.class,  forVariable(variable));
    }

    public QAccountName(Path<? extends AccountName> path) {
        super(path.getType(), path.getMetadata());
    }

    public QAccountName(PathMetadata<?> metadata) {
        super(AccountName.class,  metadata);
    }

}

