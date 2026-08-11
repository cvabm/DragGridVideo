# Release signing (public, intentionally not secret)

This keystore is committed on purpose so CI can sign release builds without secrets.

| Field | Value |
|-------|-------|
| File | `release.jks` |
| Store password | `android` |
| Key alias | `release` |
| Key password | `android` |
| Validity | 10000 days |

Do **not** use this keystore for a real Play Store listing you care about.
