import {
  ComponentState,
  Dispatch,
  RefObject,
  SetStateAction,
  useCallback,
  useEffect,
  useRef,
  useState,
} from "react";

/* @tsline-disable */

/*
 * Credit: https://github.com/bitmap/react-hook-inview | MIT
 */

type Ref = Element | null;
type SetRef = Dispatch<SetStateAction<Ref>>;
type ExternalState = ComponentState[];

type OnIntersectCallback = (
  entry: IntersectionObserverEntry,
  observer: IntersectionObserver
) => void;

interface UseInViewOptions extends IntersectionObserverInit {
  target?: RefObject<Ref>;
  onEnter?: OnIntersectCallback;
  onLeave?: OnIntersectCallback;
  unobserveOnEnter?: boolean;
}

interface UseInViewState {
  isIntersecting: boolean;
  entry: IntersectionObserverEntry | null;
}

type Hook = [
  SetRef,
  UseInViewState["isIntersecting"],
  UseInViewState["entry"],
  IntersectionObserver | null
];

type UseObserver = (
  ref: Ref,
  callback: IntersectionObserverCallback,
  options?: IntersectionObserverInit,
  externalState?: ExternalState
) => IntersectionObserver | null;

type UseInViewEffect = (
  callback: IntersectionObserverCallback,
  options?: IntersectionObserverInit,
  externalState?: ExternalState
) => SetRef;

type UseInView = (
  options?: UseInViewOptions,
  externalState?: ExternalState
) => Hook;

const useObserver: UseObserver = (
  ref,
  callback,
  options = {},
  externalState = []
) => {
  const Observer = useRef<IntersectionObserver | null>(null);
  const onIntersect = useCallback(callback, [ref, ...externalState]);

  useEffect(() => {
    /* there's no IntersectionObserver in IE11 */
    if (
      !("IntersectionObserver" in window) ||
      !("IntersectionObserverEntry" in window) ||
      !("intersectionRatio" in window.IntersectionObserverEntry.prototype)
    ) {
      return;
    }

    if (!ref) {
      return;
    }

    if (Observer.current) {
      Observer.current.unobserve(ref);
    }
    Observer.current = new IntersectionObserver(onIntersect, options);

    const { current: currentObserver } = Observer;

    currentObserver.observe(ref);
    return (): void => currentObserver.unobserve(ref);
  }, [ref, ...externalState]);

  return Observer.current;
};

export const useInViewEffect: UseInViewEffect = (
  callback,
  options = {},
  externalState = []
) => {
  const [ref, setRef] = useState<Ref>(null);

  useObserver(ref, callback, options, externalState);

  return setRef;
};

export const useInView: UseInView = (options, externalState = []) => {
  const { ...ops } = options;

  const {
    root = null,
    rootMargin = "0px 0px 0px 0px",
    threshold = 0,
    target,
    onEnter,
    onLeave,
    unobserveOnEnter,
  } = ops;

  const [ref, setRef] = useState<Ref>(null);
  const [state, setState] = useState<UseInViewState>({
    isIntersecting: false,
    entry: null,
  });

  // tslint:disable-next-line: no-shadowed-variable
  const callback: IntersectionObserverCallback = ([entry], observer): void => {
    if (!ref || !entry || !observer) {
      return;
    }

    const { isIntersecting } = entry;

    setState({
      isIntersecting,
      entry,
    });

    if (isIntersecting) {
      // tslint:disable-next-line: no-unused-expression
      onEnter && onEnter(entry, observer);
      if (unobserveOnEnter) {
        observer.unobserve(ref);
      }
    } else {
      // tslint:disable-next-line: no-unused-expression
      onLeave && onLeave(entry, observer);
    }
  };

  useEffect(() => {
    if (!target) {
      return;
    }
    setRef(target.current);
  }, [target]);

  const observer = useObserver(
    ref,
    callback,
    { root, rootMargin, threshold },
    externalState
  );

  return [setRef, state.isIntersecting, state.entry, observer];
};
