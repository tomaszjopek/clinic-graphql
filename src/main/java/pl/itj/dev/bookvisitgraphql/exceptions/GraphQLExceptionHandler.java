package pl.itj.dev.bookvisitgraphql.exceptions;

import graphql.GraphQLError;
import graphql.GraphqlErrorBuilder;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.graphql.execution.DataFetcherExceptionResolverAdapter;
import org.springframework.graphql.execution.ErrorType;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintViolationException;

@Component
public class GraphQLExceptionHandler extends DataFetcherExceptionResolverAdapter {

    @Override
    protected GraphQLError resolveToSingleError(Throwable ex, DataFetchingEnvironment env) {
        return switch (ex) {
            case ConstraintViolationException e -> createValidationError(e, env);
            default -> super.resolveToSingleError(ex, env);
        };
    }

    private GraphQLError createValidationError(ConstraintViolationException ex, DataFetchingEnvironment env) {
        return GraphqlErrorBuilder
                .newError(env)
                .message(ex.getMessage())
                .errorType(ErrorType.BAD_REQUEST)
                .build();
    }
}
