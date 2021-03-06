// AUTOGENERATED CODE.  DO NOT MODIFY DIRECTLY!  Instead, please modify the transformer/WrapperTransformerX.ftl file.
// See the README in the module's src/template directory for details.
package com.linkedin.dagli.transformer;

import com.linkedin.dagli.annotation.equality.ValueEquality;
import com.linkedin.dagli.objectio.ObjectReader;
import com.linkedin.dagli.preparer.Preparer7;
import com.linkedin.dagli.preparer.PreparerContext;
import com.linkedin.dagli.producer.internal.ChildProducerInternalAPI;
import com.linkedin.dagli.reducer.Reducer;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;


/**
 * Base class for a preparable transformer that wraps another transformer of the same arity (number of inputs).
 *
 * The primary use case for wrapped transformers is "decorating" another transformer to give it more descriptive names
 * for its {@code withInput(...)} methods or other "syntactic sugar".  This is especially useful for creating a
 * user-friendly transformer from a DAG.
 *
 * @param <A> the type of the first input to the transformer
 * @param <B> the type of the second input to the transformer
 * @param <C> the type of the third input to the transformer
 * @param <D> the type of the fourth input to the transformer
 * @param <E> the type of the fifth input to the transformer
 * @param <F> the type of the sixth input to the transformer
 * @param <G> the type of the seventh input to the transformer
 * @param <R> the type of result produced by the transformer
 * @param <S> the type of the transformer deriving from this base class
 */
@ValueEquality
public class WrapperTransformer7<A, B, C, D, E, F, G, R, S extends WrapperTransformer7<A, B, C, D, E, F, G, R, S>>
    extends AbstractPreparableTransformer7<A, B, C, D, E, F, G, R, PreparedTransformer7<A, B, C, D, E, F, G, R>, S> {

  private static final long serialVersionUID = 1;

  protected PreparableTransformer7<A, B, C, D, E, F, G, R, ?> _wrappedTransformer = null;

  @Override
  public void validate() {
    super.validate();
    _wrappedTransformer.validate();
  }

  @Override
  protected Collection<? extends Reducer<? super S>> getGraphReducers() {
    // replace the wrapper transformer with the wrapped transformer
    return Collections.singletonList((wrapper, context) -> context.replace(wrapper,
        ChildProducerInternalAPI.withInputsUnsafe(wrapper._wrappedTransformer, context.getParents(wrapper))));
  }

  @Override
  protected boolean hasAlwaysConstantResult() {
    return _wrappedTransformer.internalAPI().hasAlwaysConstantResult();
  }

  /**
   * Constructs a new instance that will wrap the provided transformer.
   *
   * The new instance will inherit the wrapped transformer's inputs.
   *
   * @param wrappedTransformer the transformer to wrap
   */
  public WrapperTransformer7(
      PreparableTransformer7<? super A, ? super B, ? super C, ? super D, ? super E, ? super F, ? super G, ? extends R, ?> wrappedTransformer) {
    setWrappedTransformer(wrappedTransformer);
  }

  /**
   * Constructs a new instance that will initially lack a wrapped transformer (this should be set during the derived
   * class' constructor using {@link #setWrappedTransformer(PreparableTransformer7)}
   */
  public WrapperTransformer7() {
  }

  /**
   * Constructs a new instance that will wrap the provided transformer.
   *
   * The new instance will inherit the wrapped transformer's inputs.
   *
   * @param wrapped the transformer to wrap
   */
  protected WrapperTransformer7<A, B, C, D, E, F, G, R, S> withWrappedTransformer(
      PreparableTransformer7<? super A, ? super B, ? super C, ? super D, ? super E, ? super F, ? super G, ? extends R, ?> wrapped) {
    return clone(c -> c.setWrappedTransformer(wrapped));
  }

  /**
   * Sets the wrapped transformer and inherits its inputs (which become this instance's inputs).   This method should
   * <strong>only</strong> be called on new instances before they are returned to the client (e.g. during a
   * constructor).
   *
   * @param wrapped the wrapped transformer
   */
  protected void setWrappedTransformer(
      PreparableTransformer7<? super A, ? super B, ? super C, ? super D, ? super E, ? super F, ? super G, ? extends R, ?> wrapped) {
    _wrappedTransformer = PreparableTransformer7.castWithGenericPrepared(wrapped);
    _input1 = _wrappedTransformer.internalAPI().getInput1();
    _input2 = _wrappedTransformer.internalAPI().getInput2();
    _input3 = _wrappedTransformer.internalAPI().getInput3();
    _input4 = _wrappedTransformer.internalAPI().getInput4();
    _input5 = _wrappedTransformer.internalAPI().getInput5();
    _input6 = _wrappedTransformer.internalAPI().getInput6();
    _input7 = _wrappedTransformer.internalAPI().getInput7();
    // replace _wrapped's inputs with placeholders to avoid storing references to the original inputs when/if the
    // wrapper transformer's inputs change
    _wrappedTransformer = Transformer.withPlaceholderInputs(_wrappedTransformer);
  }

  @Override
  protected boolean hasIdempotentPreparer() {
    return _wrappedTransformer.internalAPI().hasIdempotentPreparer();
  }

  @Override
  protected Preparer7<A, B, C, D, E, F, G, R, PreparedTransformer7<A, B, C, D, E, F, G, R>> getPreparer(
      PreparerContext context) {
    return Preparer7.cast(_wrappedTransformer.internalAPI().getPreparer(context));
  }

  /**
   * Base class for a prepared transformer that wraps another transformer of the same arity (number of inputs).
   *
   * The primary use case for wrapped transformers is "decorating" another transformer to give it more descriptive names
   * for its {@code withInput(...)} methods or other "syntactic sugar".  This is especially useful for creating a
   * user-friendly transformer from a DAG.
   *
  * @param <A> the type of the first input to the transformer
  * @param <B> the type of the second input to the transformer
  * @param <C> the type of the third input to the transformer
  * @param <D> the type of the fourth input to the transformer
  * @param <E> the type of the fifth input to the transformer
  * @param <F> the type of the sixth input to the transformer
  * @param <G> the type of the seventh input to the transformer
  * @param <R> the type of result produced by the transformer
   * @param <S> the type of the transformer deriving from this base class
   */
  @ValueEquality
  public static abstract class Prepared<A, B, C, D, E, F, G, R, S extends WrapperTransformer7.Prepared<A, B, C, D, E, F, G, R, S>>
      extends AbstractPreparedStatefulTransformer7<A, B, C, D, E, F, G, R, Object, S> {

    private static final long serialVersionUID = 1;

    protected PreparedTransformer7<A, B, C, D, E, F, G, R> _wrappedTransformer = null;

    @Override
    public void validate() {
      super.validate();
      _wrappedTransformer.validate();
    }

    @Override
    protected Collection<? extends Reducer<? super S>> getGraphReducers() {
      // replace the wrapper transformer with the wrapped transformer
      return Collections.singletonList((wrapper, context) -> context.replace(wrapper,
          ChildProducerInternalAPI.withInputsUnsafe(wrapper._wrappedTransformer, context.getParents(wrapper))));
    }

    @Override
    protected boolean hasAlwaysConstantResult() {
      return _wrappedTransformer.internalAPI().hasAlwaysConstantResult();
    }

    /**
     * Constructs a new instance that will wrap the provided transformer.
     *
     * The new instance will inherit the wrapped transformer's inputs.
     *
     * @param wrappedTransformer the transformer to wrap
     */
    public Prepared(
        PreparedTransformer7<? super A, ? super B, ? super C, ? super D, ? super E, ? super F, ? super G, ? extends R> wrappedTransformer) {
      setWrappedTransformer(wrappedTransformer);
    }

    /**
     * Constructs a new instance that will initially lack a wrapped transformer (this should be set during the derived
     * class' constructor using {@link #setWrappedTransformer(PreparedTransformer7)}
     */
    public Prepared() {
    }

    /**
     * Constructs a new instance that will wrap the provided transformer.
     *
     * The new instance will inherit the wrapped transformer's inputs.
     *
     * @param wrapped the transformer to wrap
     */
    protected WrapperTransformer7.Prepared<A, B, C, D, E, F, G, R, S> withWrappedTransformer(
        PreparedTransformer7<? super A, ? super B, ? super C, ? super D, ? super E, ? super F, ? super G, ? extends R> wrapped) {
      return clone(c -> c.setWrappedTransformer(wrapped));
    }

    /**
     * Sets the wrapped transformer and inherits its inputs (which become this instance's inputs).   This method should
     * <strong>only</strong> be called on new instances before they are returned to the client (e.g. during a
     * constructor).
     *
     * @param wrapped the wrapped transformer
     */
    protected void setWrappedTransformer(
        PreparedTransformer7<? super A, ? super B, ? super C, ? super D, ? super E, ? super F, ? super G, ? extends R> wrapped) {
      _wrappedTransformer = PreparedTransformer7.cast(wrapped);
      _input1 = _wrappedTransformer.internalAPI().getInput1();
      _input2 = _wrappedTransformer.internalAPI().getInput2();
      _input3 = _wrappedTransformer.internalAPI().getInput3();
      _input4 = _wrappedTransformer.internalAPI().getInput4();
      _input5 = _wrappedTransformer.internalAPI().getInput5();
      _input6 = _wrappedTransformer.internalAPI().getInput6();
      _input7 = _wrappedTransformer.internalAPI().getInput7();
      // replace _wrapped's inputs with placeholders to avoid storing references to the original inputs when/if the
      // wrapper transformer's inputs change
      _wrappedTransformer = Transformer.withPlaceholderInputs(_wrappedTransformer);
    }

    @Override
    public R apply(A value1, B value2, C value3, D value4, E value5, F value6, G value7) {
      return _wrappedTransformer.apply(value1, value2, value3, value4, value5, value6, value7);
    }

    @Override
    public ObjectReader<R> applyAll(Iterable<? extends A> values1, Iterable<? extends B> values2,
        Iterable<? extends C> values3, Iterable<? extends D> values4, Iterable<? extends E> values5,
        Iterable<? extends F> values6, Iterable<? extends G> values7) {
      return _wrappedTransformer.applyAll(values1, values2, values3, values4, values5, values6, values7);
    }

    @Override
    protected R apply(Object executionCache, A value1, B value2, C value3, D value4, E value5, F value6, G value7) {
      return _wrappedTransformer.internalAPI().apply(executionCache, value1, value2, value3, value4, value5, value6,
          value7);
    }

    @Override
    protected void applyAll(Object executionCache, List<? extends A> values1, List<? extends B> values2,
        List<? extends C> values3, List<? extends D> values4, List<? extends E> values5, List<? extends F> values6,
        List<? extends G> values7, List<? super R> results) {
      _wrappedTransformer.internalAPI().applyAllUnsafe(executionCache, values1.size(),
          Arrays.asList(values1, values2, values3, values4, values5, values6, values7), results);
    }

    @Override
    protected Object createExecutionCache(long exampleCountGuess) {
      return _wrappedTransformer.internalAPI().createExecutionCache(exampleCountGuess);
    }

    @Override
    protected int getPreferredMinibatchSize() {
      return super.getPreferredMinibatchSize();
    }
  }
}
