# atproto

`kotoba-lang/atproto` is the shared EDN/CLJC contract library for AT Protocol
components used by `kotoba-lang/kotoba`, `app-aozora`, and future actors.

It is not an application PDS. It owns portable protocol vocabulary and pure
record helpers so app-specific Workers stop redefining the same constants.

Initial scope:

- NSID and collection metadata
- repo URI helpers
- standard `app.bsky.actor.profile` record construction
- route metadata for common PDS/AppView XRPC surfaces
- migration map from current `app-aozora` implementation namespaces

Cryptographic byte-level pieces are split by responsibility:

- `kotoba-lang/mst`: MST layer/key primitives
- `kotoba-lang/dag-cbor`: DAG-CBOR encoding
- `kotoba-lang/multiformats`: CID/base encodings
- `kotoba-lang/did`: DID parsing/document helpers
- this repo: AT Protocol contract/API shape tying those libraries together

## Test

```bash
clojure -M:test
```

## License

MIT
