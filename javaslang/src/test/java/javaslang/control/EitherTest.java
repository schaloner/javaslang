/*     / \____  _    _  ____   ______  / \ ____  __    _ _____
 *    /  /    \/ \  / \/    \ /  /\__\/  //    \/  \  / /  _  \   Javaslang
 *  _/  /  /\  \  \/  /  /\  \\__\\  \  //  /\  \ /\\/  \__/  /   Copyright 2014-now Daniel Dietrich
 * /___/\_/  \_/\____/\_/  \_/\__\/__/___\_/  \_//  \__/_____/    Licensed under the Apache License, Version 2.0
 */
package javaslang.control;

import javaslang.AbstractValueTest;
import org.junit.Test;

import java.util.Objects;

public class EitherTest extends AbstractValueTest {

    // -- AbstractValueTest

    @Override
    protected <T> Either<?, T> empty() {
        return Either.<T, T> left(null);
    }

    @Override
    protected <T> Either<?, T> of(T element) {
        return Either.<T, T> right(element);
    }

    @SafeVarargs
    @Override
    protected final <T> Either<?, T> of(T... elements) {
        return of(elements[0]);
    }

    @Override
    protected boolean useIsEqualToInsteadOfIsSameAs() {
        return true;
    }

    @Override
    protected int getPeekNonNilPerformingAnAction() {
        return 1;
    }

    // -- Either

    @Test
    public void shouldBimapLeft() {
        final Either<Integer, String> actual = Either.<Integer, String>left(1).bimap(i -> i + 1, s -> s + "1");
        final Either<Integer, String> expected = Either.left(2);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void shouldBimapRight() {
        final Either<Integer, String> actual = Either.<Integer, String>right("1").bimap(i -> i + 1, s -> s + "1");
        final Either<Integer, String> expected = Either.right("11");
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void shouldFoldLeft() {
        final String value = Either.left("L").fold(l -> l + "+", r -> r + "-");
        assertThat(value).isEqualTo("L+");
    }

    @Test
    public void shouldFoldRight() {
        final String value = Either.right("R").fold(l -> l + "-", r -> r + "+");
        assertThat(value).isEqualTo("R+");
    }

    @Test
    public void shouldSwapLeft() {
        assertThat(Either.left(1).swap()).isEqualTo(Either.right(1));
    }

    @Test
    public void shouldSwapRight() {
        assertThat(Either.right(1).swap()).isEqualTo(Either.left(1));
    }

    // orElse

    @Test
    public void shouldEitherOrElseEither() {
        assertThat(Either.right(1).orElse(Either.right(2)).get()).isEqualTo(1);
        assertThat(Either.left(1).orElse(Either.right(2)).get()).isEqualTo(2);
    }

    // -- Left

    @Test
    public void shouldReturnTrueWhenCallingIsLeftOnLeft() {
        assertThat(Either.left(1).isLeft()).isTrue();
    }

    @Test
    public void shouldReturnFalseWhenCallingIsRightOnLeft() {
        assertThat(Either.left(1).isRight()).isFalse();
    }

    // equals

    @Test
    public void shouldEqualLeftIfObjectIsSame() {
        final Either<Integer, ?> left = Either.left(1);
        assertThat(left.equals(left)).isTrue();
    }

    @Test
    public void shouldNotEqualLeftIfObjectIsNull() {
        assertThat(Either.left(1).equals(null)).isFalse();
    }

    @Test
    public void shouldNotEqualLeftIfObjectIsOfDifferentType() {
        assertThat(Either.left(1).equals(new Object())).isFalse();
    }

    @Test
    public void shouldEqualLeft() {
        assertThat(Either.left(1)).isEqualTo(Either.left(1));
    }

    // hashCode

    @Test
    public void shouldHashLeft() {
        assertThat(Either.left(1).hashCode()).isEqualTo(Objects.hashCode(1));
    }

    // toString

    @Test
    public void shouldConvertLeftToString() {
        assertThat(Either.left(1).toString()).isEqualTo("Left(1)");
    }

    // -- Right

    @Test
    public void shouldReturnTrueWhenCallingIsRightOnRight() {
        assertThat(Either.right(1).isRight()).isTrue();
    }

    @Test
    public void shouldReturnFalseWhenCallingIsLeftOnRight() {
        assertThat(Either.right(1).isLeft()).isFalse();
    }

    // equals

    @Test
    public void shouldEqualRightIfObjectIsSame() {
        final Either<?, ?> right = Either.right(1);
        assertThat(right.equals(right)).isTrue();
    }

    @Test
    public void shouldNotEqualRightIfObjectIsNull() {
        assertThat(Either.right(1).equals(null)).isFalse();
    }

    @Test
    public void shouldNotEqualRightIfObjectIsOfDifferentType() {
        assertThat(Either.right(1).equals(new Object())).isFalse();
    }

    @Test
    public void shouldEqualRight() {
        assertThat(Either.right(1)).isEqualTo(Either.right(1));
    }

    // hashCode

    @Test
    public void shouldHashRight() {
        assertThat(Either.right(1).hashCode()).isEqualTo(Objects.hashCode(1));
    }

    // toString

    @Test
    public void shouldConvertRightToString() {
        assertThat(Either.right(1).toString()).isEqualTo("Right(1)");
    }

}